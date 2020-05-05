package com.example.mrvova96.weatherforecast.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mrvova96.weatherforecast.R;

public class SettingsActivity extends AppCompatActivity {

    TextView infoField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        infoField = findViewById(R.id.info_field);

        setToolbar();
        displayInfo();
    }

    public void displayInfo() {
        infoField.setText(R.string.settings_info);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void setToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar_info));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
