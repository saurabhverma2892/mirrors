package com.example.saurabh.mirrors;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VerificationSplash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1000;
    private PreferencesManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_splash);
        prefManager = new PreferencesManager(this);

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                    launchGetDetailsScreen();
            }
        }, SPLASH_TIME_OUT);

    }

    private void launchGetDetailsScreen() {
        Intent i = new Intent(VerificationSplash.this, UserDetails.class);
        startActivity(i);
        finish();
    }
}
