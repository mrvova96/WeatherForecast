package com.example.mrvova96.weatherforecast.model;

import java.util.ArrayList;
import java.util.List;

public class CitiesList {

    public List<City> getCities() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Арханельск"));
        cities.add(new City("Вологда"));
        cities.add(new City("Грязовец"));
        cities.add(new City("Казань"));
        cities.add(new City("Кострома"));
        cities.add(new City("Москва"));
        cities.add(new City("Мурманск"));
        cities.add(new City("Санкт-Петербург"));
        cities.add(new City("Сочи"));
        cities.add(new City("Ярославль"));
        return cities;
    }
}
