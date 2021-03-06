package bram.bramsierhuis.nl.workinghours;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if(!(SaveSharedPreference.getUserName(MainActivity.this).length() == 0)){
            Intent intent = new Intent(MainActivity.this, SubmitTimesActivity.class);
            startActivity(intent);
        }
    }

    @OnClick(R.id.button)
    public void onNext(){
        Intent intent = new Intent(this, SubmitTimesActivity.class);
        startActivity(intent);
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
}
