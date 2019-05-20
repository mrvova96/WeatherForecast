package com.example.mrvova96.weatherforecast.ui;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mrvova96.weatherforecast.R;
import com.example.mrvova96.weatherforecast.fragment.OneDayFragment;

public class WeatherDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);
        Intent intent = getIntent();
        String temp = intent.getStringExtra("temp");
        System.out.println(temp);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, OneDayFragment.newInstance(temp)).commit();
    }
}
