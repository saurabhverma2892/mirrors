package com.example.saurabh.mirrors;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import java.util.Objects;

public class EnterOTP extends AppCompatActivity {

    private static final String TAG = "Mirrors";
    private TextView phoneNumberTextView;
    private TextView sendAgainOtpButton;
    private EditText otpInput;
    private Button otpVerifyButton;
    private Context context;
    private PreferencesManager prefManager;
    private String phoneNumber;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otp);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.phoneNumberToolbar);
        setSupportActionBar(myToolbar);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("Login");
        actionbar.setDisplayHomeAsUpEnabled(true);

        prefManager = new PreferencesManager(this);
        phoneNumberTextView = (TextView) findViewById(R.id.phoneNumberTextView);
        sendAgainOtpButton = (TextView) findViewById(R.id.sendAgainOtpButton);
        otpVerifyButton = (Button) findViewById(R.id.otpVerifyButton);
        otpInput = (EditText) findViewById(R.id.otpInput);
        context = this;

        phoneNumber = getIntent().getStringExtra("phoneNumber");
        phoneNumberTextView.setText(phoneNumber);

        otpVerifyButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        verifyToken();
                    }
                }
        );

        sendAgainOtpButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resendOTP();
                    }
                }
        );
    }

    private void resendOTP() {
        //TODO:resend OTP.
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void verifyToken() {
        String otp = otpInput.getText().toString();
        Log.i(TAG, "running here"+otpInput.getText().toString());
        if(Objects.equals(otp, "123")){
            //TODO: see equals.

            launchVerificationScreen();
        }
        else
        {
            Log.i(TAG, "running here3"+otp);
            /*Toast toast = new Toast(Context context, "wrong otp entered", 2000);
            toast.show();*/
        }
    }

    private void launchVerificationScreen() {
        prefManager.setPhoneNumber(phoneNumber);
        prefManager.setIsLoggedIn(true);
        Intent i = new Intent(EnterOTP.this, VerificationSplash.class);
        startActivity(i);
        finish();
    }
}