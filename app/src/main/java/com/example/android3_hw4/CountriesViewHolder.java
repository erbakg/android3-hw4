package com.example.android3_hw4;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3_hw4.databinding.ItemCountriesBinding;

public class CountriesViewHolder extends RecyclerView.ViewHolder {
    private ItemCountriesBinding binding;
    public CountriesViewHolder(@NonNull ItemCountriesBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
    public void onBind(String continentName) {
        binding.ivCountryName.setText(continentName);
    }
}
