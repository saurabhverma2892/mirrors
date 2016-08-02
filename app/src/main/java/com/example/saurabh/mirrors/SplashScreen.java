package com.example.saurabh.mirrors;

/**
 * Created by saurabh on 29/07/16.
 */
//import org.json.JSONException;
//import org.json.JSONObject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

//import android.os.AsyncTask;
//import android.util.Log;


public class SplashScreen extends Activity{

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    private PreferencesManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_splash);
        prefManager = new PreferencesManager(this);

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                if (!prefManager.isFirstTimeLaunch()) {
                    if(prefManager.getPhoneNumber().length()>9){
                        launchMainScreen();
                    }
                    else
                    {
                        launchHomeScreen();
                    }
                }
                else
                {
                    launchIntroScreen();
                }
            }
        }, SPLASH_TIME_OUT);

    }

    private void launchMainScreen() {
        Intent i = new Intent(SplashScreen.this, MainPage.class);
        startActivity(i);
        finish();
    }

    private void launchIntroScreen() {
        startActivity(new Intent(SplashScreen.this, WelcomeActivity.class));
        finish();
    }

    private void launchHomeScreen() {
        startActivity(new Intent(SplashScreen.this, MainLogin.class));
        finish();
    }

    @Override
    public void onBackPressed() {

    }

}
