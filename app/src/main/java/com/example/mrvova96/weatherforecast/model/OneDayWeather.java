package com.example.mrvova96.weatherforecast.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OneDayWeather {

    public OneDayWeather(String city, WeatherTemp temp, List<WeatherInfo> info) {
        this.city = city;
        this.temp = temp;
        this.info = info;
    }

    public class WeatherTemp {
        Double temp;
        Double temp_min;
        Double temp_max;
    }

    public class WeatherInfo {
        String icon;
    }
    @SerializedName("name")
    private String city;

    @SerializedName("main")
    private WeatherTemp temp;

    @SerializedName("weather")
    private List<WeatherInfo> info;

    public String getCity() {
        return city;
    }

    public String getTemp() {
        return String.valueOf(temp.temp);
    }

    public String getTempMin() {
        return String.valueOf(temp.temp_min);
    }

    public String getTempMax() {
        return String.valueOf(temp.temp_max);
    }

    public String getIconURL() {
        return "https://openweathermap.org/img/w/" + info.get(0).icon + ".png";
    }
}
