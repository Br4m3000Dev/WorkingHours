package bram.bramsierhuis.nl.workinghours;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.usernameEditText) EditText usernameEditText;
    @BindView(R.id.passEditText) EditText passEditText;
    @BindView(R.id.stayLoggedInCheckBox) CheckBox stayLoggedInCheckBox;

    private Call<String> loginApiCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(loginApiCall != null){
            loginApiCall.cancel();
        }
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
                    if(response.body().equals("Login succesfull. ")){
                        if(stayLoggedInCheckBox.isChecked()){
                            SaveSharedPreference.setUserName(LoginActivity.this, usernameEditText.getText().toString());
                        } else{
                            SaveSharedPreference.setUserName(LoginActivity.this, "");
                        }

                        GlobalVariables.setUsername(usernameEditText.getText().toString());
                        Intent intent = new Intent(LoginActivity.this, SubmitTimesActivity.class);
                        startActivity(intent);

                    } else{
                        new AlertDialog.Builder(LoginActivity.this)
                                .setTitle(R.string.alert)
                                .setMessage(response.body())
                                .create()
                                .show();
                    }
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
