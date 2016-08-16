package com.example.saurabh.mirrors;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by saurabh on 29/07/16.
 */
public class MainLogin extends AppCompatActivity{

    private Button loginNumberButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        loginNumberButton = (Button) findViewById(R.id.loginNumber);

        loginNumberButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        launchNumberLogin();
                    }
                }
        );
    }

    private void launchNumberLogin() {
        Intent i = new Intent(MainLogin.this, EnterPhoneNumber.class);
        startActivity(i);
    }
}