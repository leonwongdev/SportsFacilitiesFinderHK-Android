package com.example.sportsfacilitiesfinderhk.network;

import com.example.sportsfacilitiesfinderhk.models.SportFacility;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataGovHkApi {
//TODO: Finish Endpoint
    @GET("facility-hbc.json")
    Call<List<SportFacility>> getHandballCourts();

    @GET("facility-nbc.json")
    Call<List<SportFacility>> getNetballCourts();

    @GET("facility-sbg.json")
    Call<List<SportFacility>> getSkateboardGrounds1();

    @GET("facility-sp.json")
    Call<List<SportFacility>> getSkateboardGrounds2();

    @GET("facility-ar.json")
    Call<List<SportFacility>> getArcheryRanges();

    @GET("facility-bvbc.json")
    Call<List<SportFacility>> getBeachVolleyballCourts();

    @GET("facility-rsr.json")
    Call<List<SportFacility>> getRollerSkatingRinks();

    @GET("facility-gbc.json")
    Call<List<SportFacility>> getGateballCourts();

    @GET("facility-cgatp.json")
    Call<List<SportFacility>> getCricketGrounds1();

    @GET("facility-cgf.json")
    Call<List<SportFacility>> getCricketGrounds2();

    @GET("facility-cgntp.json")
    Call<List<SportFacility>> getCricketGrounds3();

}
