package com.example.android3_hw4;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3_hw4.databinding.ItemContinentBinding;

import java.util.ArrayList;

public class ContinentsAdapter extends RecyclerView.Adapter<ContinentsViewHolder> {

    private ArrayList<Continent> continentsList;

    private OnItemClick onContinentClick;

    public ContinentsAdapter(ArrayList<Continent> continentsList, OnItemClick onContinentClick) {
        this.continentsList = continentsList;
        this.onContinentClick = onContinentClick;
    }

    @NonNull
    @Override
    public ContinentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContinentsViewHolder(ItemContinentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentsViewHolder holder, int position) {
        holder.onBind(continentsList.get(position).getEnglishName());
        holder.itemView.setOnClickListener(view -> {
            onContinentClick.onItemClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return continentsList.size();
    }
}
