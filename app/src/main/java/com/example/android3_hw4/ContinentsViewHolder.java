package com.example.android3_hw4;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3_hw4.databinding.ItemContinentBinding;

public class ContinentsViewHolder extends RecyclerView.ViewHolder {

    private ItemContinentBinding binding;

    public ContinentsViewHolder(@NonNull ItemContinentBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(String continentName) {
        binding.ivContinentName.setText(continentName);
    }
}
