package com.example.mrvova96.weatherforecast.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.mrvova96.weatherforecast.BuildConfig;
import com.example.mrvova96.weatherforecast.R;
import com.example.mrvova96.weatherforecast.adapter.WeatherAdapter;
import com.example.mrvova96.weatherforecast.model.CitiesList;
import com.example.mrvova96.weatherforecast.model.OneDayWeather;
import com.example.mrvova96.weatherforecast.network.InterfaceAPI;
import com.example.mrvova96.weatherforecast.network.WeatherAPI;
import com.example.mrvova96.weatherforecast.util.RecyclerItemClickListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    InterfaceAPI interfaceAPI;
    WeatherAdapter adapter;
    CitiesList list = new CitiesList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        adapter = new WeatherAdapter(list.getCities());
        recyclerView.setAdapter(adapter);
        WeatherAPI.getClient()
                .create(InterfaceAPI.class)
                .getWeatherForOneDay("London", BuildConfig.API_KEY, BuildConfig.UNITS, BuildConfig.LANGUAGE)
                .enqueue(new Callback<OneDayWeather>() {

                    @Override
                    public void onResponse(@NonNull Call<OneDayWeather> call, @NonNull Response<OneDayWeather> response) {
                        Log.e("WEATHER", "onResponse");

                        OneDayWeather data = response.body();
                        Intent intent = new Intent(getApplicationContext(), WeatherDetailActivity.class);
                        intent.putExtra("temp", data.getTemp());
                        intent.putExtra("icon", data.getIconURL());
                        startActivity(intent);
                        //cityName.setText(data.getCity() + ", " + data.getTemp());
                        //Glide.with(MainActivity.this).load(data.getIconURL()).into(icon);
                    }

                    @Override
                    public void onFailure(@NonNull Call<OneDayWeather> call, @NonNull Throwable t) {
                        Log.e("WEATHER", "onFailure");
                    }
                });
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    public void onItemClickListener() {
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int i) {
                        String cityName = list.getCities().get(i).getName();
                        loadData(cityName);
                    }

                    @Override
                    public void onLongItemClick(View view, int i) {
                        // It's not required
                    }
                })
        );
    }

    private void loadData(String cityName) {
        WeatherAPI.getClient()
                .create(InterfaceAPI.class)
                .getWeatherForOneDay(cityName, BuildConfig.API_KEY, BuildConfig.UNITS, BuildConfig.LANGUAGE)
                .enqueue(new Callback<OneDayWeather>() {

            @Override
            public void onResponse(@NonNull Call<OneDayWeather> call, @NonNull Response<OneDayWeather> response) {
                Log.e("WEATHER", "onResponse");

                OneDayWeather data = response.body();
                Intent intent = new Intent(getApplicationContext(), WeatherDetailActivity.class);
                intent.putExtra("temp", data.getTemp());
                intent.putExtra("icon", data.getIconURL());
                startActivity(intent);
                //cityName.setText(data.getCity() + ", " + data.getTemp());
                //Glide.with(MainActivity.this).load(data.getIconURL()).into(icon);
            }

            @Override
            public void onFailure(@NonNull Call<OneDayWeather> call, @NonNull Throwable t) {
                Log.e("WEATHER", "onFailure");
            }
        });
    }
}
