package com.example.mrvova96.weatherforecast.network;

import com.example.mrvova96.weatherforecast.model.FiveDaysWeather;
import com.example.mrvova96.weatherforecast.model.OneDayWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceAPI {

    @GET("weather")
    Call<OneDayWeather> getWeatherForOneDay(
            //@Query("id") int cityID,
            @Query("q") String city,
            @Query("APPID") String appID,
            @Query("units") String units,
            @Query("lang") String language
    );

    @GET("forecast")
    Call<FiveDaysWeather> getWeatherForFiveDays(
            //@Query("id") int cityID,
            @Query("q") String city,
            @Query("APPID") String appID,
            @Query("units") String units
    );
}
