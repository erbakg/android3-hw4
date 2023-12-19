package com.example.android3_hw4;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3_hw4.databinding.ItemCountriesBinding;

import java.util.ArrayList;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesViewHolder> {

    private ArrayList<Country> countriesList;

    public CountriesAdapter(ArrayList<Country> countriesList) {
        this.countriesList = countriesList;
    }

    @NonNull
    @Override
    public CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CountriesViewHolder(ItemCountriesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull CountriesViewHolder holder, int position) {
        holder.onBind(countriesList.get(position).getEnglishName());
    }


    @Override
    public int getItemCount() {
        return countriesList.size();
    }
}
