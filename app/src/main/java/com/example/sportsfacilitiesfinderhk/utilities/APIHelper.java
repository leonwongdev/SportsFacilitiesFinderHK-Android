package com.example.sportsfacilitiesfinderhk.utilities;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIHelper {
    public static DataGovHkApi sportsFacilitiesAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.lcsd.gov.hk/datagovhk/facility/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DataGovHkApi dataGovHkApi = retrofit.create(DataGovHkApi.class);
        return dataGovHkApi;
    }
}
