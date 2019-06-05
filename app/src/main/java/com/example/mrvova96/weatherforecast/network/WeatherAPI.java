package com.example.mrvova96.weatherforecast.network;

import com.example.mrvova96.weatherforecast.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherAPI {

    private static Retrofit.Builder retrofit = new Retrofit.Builder();

    public static Retrofit getClient() {
        return retrofit
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
