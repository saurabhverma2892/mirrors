package com.example.saurabh.mirrors;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterPhoneNumber extends AppCompatActivity {

    private static final String TAG = "Mirrors";
    private Button sendOtpButton;
    private EditText phoneNumberInput;

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
        setContentView(R.layout.activity_enter_phone_number);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.phoneNumberToolbar);
        setSupportActionBar(myToolbar);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("Login");
        actionbar.setDisplayHomeAsUpEnabled(true);



        sendOtpButton = (Button) findViewById(R.id.sendOtpButton);
        phoneNumberInput = (EditText) findViewById(R.id.phoneNumberInput);
        sendOtpButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        launchOTPVerification();
                    }
                }
        );
    }

    private void launchOTPVerification() {
        Intent i = new Intent(EnterPhoneNumber.this, EnterOTP.class);
        i.putExtra("phoneNumber", phoneNumberInput.getText().toString());
        startActivity(i);
        finish();
    }
}
