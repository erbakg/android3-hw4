package com.example.android3_hw4;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AppRequests {
    @GET("/locations/v1/regions?apikey=ib5j6bpTV5qmZSDMAWoCAIwFuLa7WHPL")
    Call<Continent[]> getContinents();

    @GET("/locations/v1/countries/{countryID}?apikey=ib5j6bpTV5qmZSDMAWoCAIwFuLa7WHPL")
    Call<Country[]> getCountries(@Path("countryID") String countryID);
}
