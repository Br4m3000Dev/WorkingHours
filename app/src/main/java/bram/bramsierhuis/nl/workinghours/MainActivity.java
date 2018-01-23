package bram.bramsierhuis.nl.workinghours;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.usernameEditText) EditText usernameEditText;
    @BindView(R.id.passEditText) EditText passEditText;
    @BindView(R.id.confirmPassEditText) EditText confirmPassEditText;

    private Call<String> registerApiCall;
    private Call<String> loginApiCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (registerApiCall != null) {
            registerApiCall.cancel();
        }

        if(loginApiCall != null){
            loginApiCall.cancel();
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
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("test")
                            .setMessage(response.body())
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

    @OnClick(R.id.loginBtn)
    public void onLogin(){
        loginApiCall = ((App)getApplicationContext()).getWorkingHoursApi().login(
                usernameEditText.getText().toString(),
                passEditText.getText().toString()
        );

        loginApiCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("test")
                            .setMessage(response.body())
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
