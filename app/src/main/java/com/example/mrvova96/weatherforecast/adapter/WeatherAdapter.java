package com.example.mrvova96.weatherforecast.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mrvova96.weatherforecast.R;
import com.example.mrvova96.weatherforecast.model.City;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.CityViewHolder> {

    private List<City> cities;

    public WeatherAdapter(List<City> cities) {
        this.cities = cities;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int i) {
        holder.cityName.setText(cities.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    class CityViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView cityName;

        CityViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            cityName = itemView.findViewById(R.id.city_name);
        }
    }
}
