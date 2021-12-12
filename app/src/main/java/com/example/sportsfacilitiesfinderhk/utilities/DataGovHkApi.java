package com.example.sportsfacilitiesfinderhk.utilities;

import com.example.sportsfacilitiesfinderhk.model.SportFacility;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataGovHkApi {
//TODO: Finish Endpoint
    @GET("facility-hbc.json")
    Call<List<SportFacility>> getHandballCourts();

    @GET("facility-nbc.json")
    Call<List<SportFacility>> getNetBallCourts();

    @GET("facility-sbg.json")
    Call<List<SportFacility>> getSkateBoardCourts();

    @GET("facility-ar.json")
    Call<List<SportFacility>> getArcheryRange();

    @GET("facility-hbc.json")
    Call<List<SportFacility>> aaaa();

    @GET("facility-hbc.json")
    Call<List<SportFacility>> as();

    @GET("facility-hbc.json")
    Call<List<SportFacility>> asd();

    @GET("facility-hbc.json")
    Call<List<SportFacility>> asdd();

}
