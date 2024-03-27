package com.example.mrvova96.weatherforecast.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mrvova96.weatherforecast.R;

import java.io.IOException;
import java.io.InputStream;

public class SettingsActivity extends AppCompatActivity {

    ImageView iconLauncher;
    TextView infoField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        infoField = findViewById(R.id.info_field);
        iconLauncher = findViewById(R.id.icon_launcher);

        setToolbar();
        displayInfo();
    }

    public void displayInfo() {
        infoField.setText(R.string.settings_info);
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
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
