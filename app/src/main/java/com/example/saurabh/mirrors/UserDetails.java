package com.example.saurabh.mirrors;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import java.util.Objects;

public class UserDetails extends AppCompatActivity {

    private PreferencesManager prefManager;
    private EditText userNameInput;
    private EditText userEmailInput;
    private EditText userMobileNoInput;
    private Button userDetailsContinueButton;

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

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.appThemeToolbar);
        setSupportActionBar(myToolbar);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("Profile Info");
        actionbar.setDisplayHomeAsUpEnabled(true);

        prefManager = new PreferencesManager(this);

        userNameInput = (EditText) findViewById(R.id.userNameInput);
        userEmailInput = (EditText) findViewById(R.id.userEmailInput);
        userMobileNoInput = (EditText) findViewById(R.id.userMobileNoInput);
        userDetailsContinueButton = (Button) findViewById(R.id.userDetailsContinueButton);

        if(!Objects.equals(prefManager.getUserName(), " ")){
            userNameInput.setText(prefManager.getUserName());
        }

        if(!Objects.equals(prefManager.getEmailId(), " ")){
            userEmailInput.setText(prefManager.getEmailId());
        }

        if(!Objects.equals(prefManager.getPhoneNumber(), " ")){
            userMobileNoInput.setText(prefManager.getPhoneNumber());
        }

        userDetailsContinueButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        launchChooseGenderScreen();
                    }
                }
        );
    }

    private void launchChooseGenderScreen() {
        Intent i = new Intent(UserDetails.this, ChooseGender.class);
        startActivity(i);
    }
}
