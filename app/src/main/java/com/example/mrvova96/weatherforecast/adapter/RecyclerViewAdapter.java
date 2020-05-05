package com.example.mrvova96.weatherforecast.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mrvova96.weatherforecast.R;
import com.example.mrvova96.weatherforecast.model.City;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CityViewHolder> {

    private List<City> cities;

    public RecyclerViewAdapter(List<City> cities) {
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

    static class CityViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView cityName;

        CityViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            cityName = itemView.findViewById(R.id.city_name);
            cityName.setOnClickListener(v -> {

            });
        }
    }
}
