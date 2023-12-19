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
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContinentsFragment extends Fragment implements OnItemClick {

    private String URL_ADDRESS = "https://dataservice.accuweather.com/";
    private String CONTINENT_ID = "continentID";

    private FragmentContinentsBinding binding;

    private ContinentsAdapter adapter;

    private ArrayList<Continent> continents = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContinentsBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        adapter = new ContinentsAdapter(continents, this);
        binding.rvContinents.setAdapter(adapter);
        binding.rvContinents.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onItemClick(int position) {
        Continent continent = continents.get(position);
        Bundle bundle = new Bundle();
        bundle.putString(CONTINENT_ID, continent.getID());

        CountriesFragment countriesFragment = new CountriesFragment();
        countriesFragment.setArguments(bundle);
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, countriesFragment)
                .addToBackStack(null)
                .commit();
    }

    private void loadData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AppRequests appRequests = retrofit.create(AppRequests.class);
        appRequests.getContinents().enqueue(new Callback<Continent[]>() {
            @Override
            public void onResponse(Call<Continent[]> call, Response<Continent[]> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        if(continents.size() == 0){
                            continents.addAll(Arrays.asList(response.body()));
                            adapter.notifyDataSetChanged();
                        }
                    }

                }

            }

            @Override
            public void onFailure(Call<Continent[]> call, Throwable t) {
                Log.d("haha", "onFailure: " + t.getMessage());
                Snackbar.make(binding.rvContinents, t.getMessage(), Snackbar.LENGTH_LONG)
                        .show();
            }
        });
    }
}