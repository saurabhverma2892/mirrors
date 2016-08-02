package com.example.saurabh.mirrors;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ChooseGender extends AppCompatActivity {

    private Button continueToMainButton;
    private Button maleButton;
    private Button femaleButton;
    private ImageView genderImageView;
    private RelativeLayout genderRelativeLayoutMain;
    private RelativeLayout genderRelativeLayoutForButtons;
    private String genderSelected;
    private PreferencesManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_gender);

        genderSelected = "M";
        prefManager = new PreferencesManager(this);
        continueToMainButton = (Button) findViewById(R.id.continueToMainButton);
        maleButton = (Button) findViewById(R.id.maleButton);
        femaleButton = (Button) findViewById(R.id.femaleButton);
        genderImageView = (ImageView) findViewById(R.id.genderImageView);
        genderRelativeLayoutMain = (RelativeLayout) findViewById(R.id.genderRelativeLayoutMain);
        genderRelativeLayoutForButtons = (RelativeLayout) findViewById(R.id.genderRelativeLayoutForButtons);

        continueToMainButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        launchMainScreen();
                    }
                }
        );

        maleButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setMaleTheme();
                    }
                }
        );

        femaleButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setFemaleTheme();
                    }
                }
        );
    }

    private void setFemaleTheme() {
        genderRelativeLayoutMain.setBackgroundResource(R.drawable.gender_female_bg);
        genderRelativeLayoutForButtons.setBackgroundColor(Color.parseColor("#581d1d"));
        maleButton.setBackgroundResource(R.drawable.male_button_f);
        continueToMainButton.setBackgroundResource(R.drawable.continue_button_f);
        femaleButton.setBackgroundResource(R.drawable.female_button_f);
        genderImageView.setImageResource(R.drawable.female_pic);

        genderSelected = "F";
    }

    private void setMaleTheme() {
        genderRelativeLayoutMain.setBackgroundResource(R.drawable.gender_male_bg);
        genderRelativeLayoutForButtons.setBackgroundColor(Color.parseColor("#163239"));
        maleButton.setBackgroundResource(R.drawable.male_button);
        continueToMainButton.setBackgroundResource(R.drawable.rounded_button);
        femaleButton.setBackgroundResource(R.drawable.female_button);
        genderImageView.setImageResource(R.drawable.male_pic);

        genderSelected = "M";
    }

    private void launchMainScreen() {

        selectGender(genderSelected);

        Intent i = new Intent(ChooseGender.this, MainPage.class);
        startActivity(i);
        finish();
    }

    private void selectGender(String genderSelected) {
        prefManager.setGender(genderSelected);
    }
}
