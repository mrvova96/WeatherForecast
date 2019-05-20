package com.example.mrvova96.weatherforecast.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FiveDaysWeather {

    @SerializedName("list")
    private List<OneDayWeather> items;

    public FiveDaysWeather(List<OneDayWeather> items) {
        this.items = items;
    }

    public List<OneDayWeather> getItems() {
        return items;
    }
}
