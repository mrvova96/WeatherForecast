package com.example.mrvova96.weatherforecast.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mrvova96.weatherforecast.R;

import java.util.Date;

public class WeatherDetailActivity extends AppCompatActivity {

    TextView locationField;
    TextView tempField;
    TextView descriptionField;
    TextView pressureField;
    TextView humidityField;
    TextView windSpeedField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);

        locationField = findViewById(R.id.location_field);
        tempField = findViewById(R.id.temp_field);
        descriptionField = findViewById(R.id.description_field);
        pressureField = findViewById(R.id.pressure_field);
        humidityField = findViewById(R.id.humidity_field);
        windSpeedField = findViewById(R.id.windSpeed_field);

        setToolbar();
        loadWeatherInfo();
    }

    private void loadWeatherInfo() {
        Intent intent = getIntent();
        String city = intent.getStringExtra("city");
        String country = intent.getStringExtra("country");
        String description = intent.getStringExtra("description");
        int humidity = intent.getIntExtra("humidity", 0);
        int temp = intent.getIntExtra("temp", 0);
        int pressure = intent.getIntExtra("pressure", 0);
        int weatherID = intent.getIntExtra("weatherID", 0);
        int windSpeed = intent.getIntExtra("windSpeed", 0);
        long sunrise = intent.getLongExtra("sunrise", 0);
        long sunset = intent.getLongExtra("sunset", 0);

        displayWeatherInfo(city, country, description, humidity, temp, pressure, weatherID, windSpeed, sunrise, sunset);
    }

    private void displayWeatherInfo(String city, String country, String description, int humidity, int temp, int pressure, int weatherID, int windSpeed, long sunrise, long sunset) {
        locationField.setText(getString(R.string.location, city, country));
        tempField.setText(getString(R.string.temp, temp));
        descriptionField.setText(description);
        pressureField.setText(getString(R.string.pressure, pressure));
        humidityField.setText(getString(R.string.humidity, humidity));
        windSpeedField.setText(getString(R.string.wind_speed, windSpeed));
        setWeatherIcon(weatherID, sunrise, sunset);
    }

    private void setWeatherIcon(int weatherID, long sunrise, long sunset) {
        Typeface weatherFont = Typeface.createFromAsset(this.getAssets(), "fonts/weather.ttf");
        TextView weatherIcon = findViewById(R.id.weatherIcon);
        weatherIcon.setTypeface(weatherFont);
        String icon = "";
        int id = weatherID / 100;
        if (weatherID == 800) {
            long currentTime = new Date().getTime();
            if (currentTime >= sunrise * 1000 && currentTime < sunset * 1000) {
                icon = this.getString(R.string.weather_sunny);
            } else {
                icon = this.getString(R.string.weather_clear_night);
            }
        } else {
            switch (id) {
                case 2:
                    icon = this.getString(R.string.weather_thunder);
                    break;
                case 3:
                    icon = this.getString(R.string.weather_drizzle);
                    break;
                case 7:
                    icon = this.getString(R.string.weather_foggy);
                    break;
                case 8:
                    icon = this.getString(R.string.weather_cloudy);
                    break;
                case 6:
                    icon = this.getString(R.string.weather_snowy);
                    break;
                case 5:
                    icon = this.getString(R.string.weather_rainy);
                    break;
            }
        }
        weatherIcon.setText(icon);
    }

    public void setToolbar() {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_info));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void onInfoAction(MenuItem item) {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    public void onSettingAction(MenuItem item) {
        Toast.makeText(this, "To be continued...", Toast.LENGTH_SHORT).show();
    }
}
