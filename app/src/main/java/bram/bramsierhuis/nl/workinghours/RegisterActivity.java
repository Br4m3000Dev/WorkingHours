package bram.bramsierhuis.nl.workinghours;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.usernameEditText) EditText usernameEditText;
    @BindView(R.id.passEditText) EditText passEditText;
    @BindView(R.id.confirmPassEditText) EditText confirmPassEditText;

    private Call<String> registerApiCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (registerApiCall != null) {
            registerApiCall.cancel();
        }
    }

    @OnClick(R.id.registerBtn)
    public void onRegister() {
        registerApiCall = ((App)getApplicationContext()).getWorkingHoursApi().register(
                usernameEditText.getText().toString(),
                passEditText.getText().toString(),
                confirmPassEditText.getText().toString()
        );

        registerApiCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    if(response.body().equals("Registration successful."))
                        new AlertDialog.Builder(RegisterActivity.this)
                                .setTitle(R.string.alert)
                                .setMessage(response.body())
                                .setPositiveButton("Log me in", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                    }
                                })
                                .create()
                                .show();
                    else
                        new AlertDialog.Builder(RegisterActivity.this)
                                .setTitle(R.string.alert)
                                .setMessage(response.body())
                                .setPositiveButton(R.string.ok, null)
                                .create()
                                .show();
                } else {
                    //TODO Server responded with an error
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                //TODO A network error occurred
            }
        });
    }
}
