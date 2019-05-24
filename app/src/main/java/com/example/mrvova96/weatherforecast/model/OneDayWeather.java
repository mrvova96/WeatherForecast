package com.example.mrvova96.weatherforecast.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OneDayWeather {

    public OneDayWeather(String city, WeatherMain main, List<WeatherInfo> info, Wind wind, OtherDetail detail) {
        this.city = city;
        this.main = main;
        this.info = info;
        this.wind = wind;
        this.detail = detail;
    }

    public class WeatherMain {
        Double temp;
        Double pressure;
        int humidity;
    }

    public class WeatherInfo {
        String description;
        int id;
    }

    public class Wind {
        Double speed;
    }

    public class OtherDetail {
        String country;
        long sunrise;
        long sunset;
    }

    @SerializedName("name")
    private String city;

    @SerializedName("main")
    private WeatherMain main;

    @SerializedName("weather")
    private List<WeatherInfo> info;

    @SerializedName("wind")
    private Wind wind;

    @SerializedName("sys")
    private OtherDetail detail;

    public String getCity() {
        return city;
    }

    public int getTemp() {
        return (int) Math.round(main.temp);
    }

    public int getPressure() {
        return (int) Math.round(main.pressure);
    }

    public int getHumidity() {
        return main.humidity;
    }

    public String getDescription() {
        return info.get(0).description;
    }

    public int getWeatherID() {
        return info.get(0).id;
    }

    public int getWindSpeed() {
        return (int) Math.round(wind.speed);
    }

    public String getCountry() {
        return detail.country;
    }

    public long getSunrise() {
        return detail.sunrise;
    }

    public long getSunset() {
        return detail.sunset;
    }
}
