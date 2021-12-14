//# COMP 4521    #  TO, Kai Yuen 20410782 kytoac@connect.ust.hk
//# COMP 4521    #  WONG, Lap Wong 20602036 lwwongaf@connect.ust.hk

package com.example.sportsfacilitiesfinderhk.network;

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
