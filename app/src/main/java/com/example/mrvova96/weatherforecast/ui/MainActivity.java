package com.example.mrvova96.weatherforecast.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mrvova96.weatherforecast.BuildConfig;
import com.example.mrvova96.weatherforecast.R;
import com.example.mrvova96.weatherforecast.adapter.RecyclerViewAdapter;
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
    RecyclerViewAdapter adapter;
    CitiesList list = new CitiesList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        initAdapter();
        initClickListener();
    }

    private void initAdapter() {
        adapter = new RecyclerViewAdapter(list.getCities());
        recyclerView.setAdapter(adapter);
    }

    public void initClickListener() {
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int i) {
                        String cityName = list.getCities().get(i).getName();
                        loadData(cityName);
                    }

                    @Override
                    public void onLongItemClick(View view, int i) {
                        Toast.makeText(getApplicationContext(), list.getCities().get(i).getName(), Toast.LENGTH_SHORT).show();
                    }
                })
        );
    }

    private void loadData(String cityName) {
        WeatherAPI.getClient()
                .create(InterfaceAPI.class)
                .getWeatherForOneDay(cityName, BuildConfig.API_KEY, BuildConfig.UNITS, BuildConfig.LANG)
                .enqueue(new Callback<OneDayWeather>() {

            @Override
            public void onResponse(@NonNull Call<OneDayWeather> call, @NonNull Response<OneDayWeather> response) {
                OneDayWeather data = response.body();
                Intent intent = new Intent(MainActivity.this, WeatherDetailActivity.class);
                intent.putExtra("city", data.getCity());
                intent.putExtra("temp", data.getTemp());
                intent.putExtra("pressure", data.getPressure());
                intent.putExtra("humidity", data.getHumidity());
                intent.putExtra("description", data.getDescription());
                intent.putExtra("weatherID", data.getWeatherID());
                intent.putExtra("windSpeed", data.getWindSpeed());
                intent.putExtra("country", data.getCountry());
                intent.putExtra("sunrise", data.getSunrise());
                intent.putExtra("sunset", data.getSunset());
                startActivity(intent);
            }

            @Override
            public void onFailure(@NonNull Call<OneDayWeather> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), "Oops, lost connection!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    public void onInfoAction(MenuItem item) {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    public void onSettingAction(MenuItem item) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
