package com.example.android3_hw4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3_hw4.databinding.FragmentContinentsBinding;
import com.example.android3_hw4.databinding.FragmentCountriesBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountriesFragment extends Fragment {
    private String URL_ADDRESS = "https://dataservice.accuweather.com/";
    private String CONTINENT_ID = "continentID";

    private FragmentCountriesBinding binding;

    private CountriesAdapter adapter;

    private ArrayList<Country> countries = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCountriesBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onLoad();
        adapter = new CountriesAdapter(countries);
        binding.rvCountries.setAdapter(adapter);
        binding.rvCountries.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void onLoad() {
        String continentID = getArguments().getString(CONTINENT_ID);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AppRequests appRequests = retrofit.create(AppRequests.class);
        appRequests.getCountries(continentID).enqueue(new Callback<Country[]>() {
            @Override
            public void onResponse(Call<Country[]> call, Response<Country[]> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        countries.addAll(Arrays.asList(response.body()));
                        adapter.notifyDataSetChanged();
                    }

                }

            }

            @Override
            public void onFailure(Call<Country[]> call, Throwable t) {
                Log.d("haha", "onFailure: " + t.getMessage());
                Snackbar.make(binding.rvCountries, t.getMessage(), Snackbar.LENGTH_LONG)
                        .show();
            }
        });

    }
}