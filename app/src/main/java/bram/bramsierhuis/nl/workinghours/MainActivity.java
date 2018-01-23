package bram.bramsierhuis.nl.workinghours;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
/*
    @BindView(R.id.usernameEditText) EditText usernameEditText;
    @BindView(R.id.passEditText) EditText passEditText;
    @BindView(R.id.confirmPassEditText) EditText confirmPassEditText;

    private Call<String> registerApiCall;
    private Call<String> loginApiCall;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.loginBtn)
    public void onLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.registerBtn)
    public void onRegister(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
/*
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
                    //TODO Handle register
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
                    //TODO Handle login
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(R.string.alert)
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
    }*/
}
