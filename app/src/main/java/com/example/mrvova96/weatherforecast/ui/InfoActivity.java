package com.example.mrvova96.weatherforecast.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mrvova96.weatherforecast.R;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;

public class InfoActivity extends AppCompatActivity {

    ImageView iconLauncher;
    TextView versionField;
    TextView licenseField;
    TextView dateField;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        versionField = findViewById(R.id.version_field);
        licenseField = findViewById(R.id.license_field);
        dateField = findViewById(R.id.date_field);
        iconLauncher = findViewById(R.id.icon_launcher);

        setToolbar();
        displayInfo();
    }

    public void displayInfo() {
        versionField.setText(R.string.version);
        licenseField.setText(R.string.license);
        dateField.setText(R.string.date);
        InputStream inputStream = null;
        try {
            inputStream = this.getAssets().open("icons/icon.png");
            iconLauncher.setImageDrawable(Drawable.createFromStream(inputStream, null));
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(inputStream!=null)
                    inputStream.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
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
