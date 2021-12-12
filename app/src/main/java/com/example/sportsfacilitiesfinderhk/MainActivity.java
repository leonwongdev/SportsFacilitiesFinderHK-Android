package com.example.sportsfacilitiesfinderhk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.sportsfacilitiesfinderhk.model.SportFacility;
import com.example.sportsfacilitiesfinderhk.utilities.APIHelper;
import com.example.sportsfacilitiesfinderhk.utilities.DataGovHkApi;
import com.example.sportsfacilitiesfinderhk.utilities.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView sportsTypeRecView;
    ArrayList<String> sports = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sports.add("football");
        sports.add("handball");
        sports.add("football2");
        sports.add("handball2");
        sports.add("football");
        sports.add("handball");
        sports.add("football2");
        sports.add("handball2");
        sportsTypeRecView = findViewById(R.id.sports_type_rec_view);
        SportsTypeRecViewAdapter sportsTypeRecViewAdapter = new SportsTypeRecViewAdapter(this,sports);
        sportsTypeRecView.setAdapter(sportsTypeRecViewAdapter);
        sportsTypeRecView.setLayoutManager(new GridLayoutManager(this,2));
        sportsTypeRecView.addItemDecoration(new GridSpacingItemDecoration(2,50,true));

        APIHelper.sportsFacilitiesAPI().getSkateBoardCourts().enqueue(new Callback<List<SportFacility>>() {
            @Override
            public void onResponse(Call<List<SportFacility>> call, Response<List<SportFacility>> response) {
                if (!response.isSuccessful()){
                    //not http 200-300
                    Toast.makeText(getApplicationContext(),
                            "response not successful",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                Log.d("TAG", response.body().get(0).getAncillaryFacilities());
            }
            @Override
            public void onFailure(Call<List<SportFacility>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),
                        "onFailure handball",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}