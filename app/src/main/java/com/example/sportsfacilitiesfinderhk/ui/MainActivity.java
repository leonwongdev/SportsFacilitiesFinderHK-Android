package com.example.sportsfacilitiesfinderhk.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.sportsfacilitiesfinderhk.R;
import com.example.sportsfacilitiesfinderhk.adapters.SportsTypeRecViewAdapter;
import com.example.sportsfacilitiesfinderhk.models.SportFacility;
import com.example.sportsfacilitiesfinderhk.network.APIHelper;
import com.example.sportsfacilitiesfinderhk.utilities.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        APIHelper.sportsFacilitiesAPI().getArcheryRange().enqueue(new Callback<List<SportFacility>>() {
            @Override
            public void onResponse(Call<List<SportFacility>> call, Response<List<SportFacility>> response) {
                if (!response.isSuccessful()){
                    //HTTP status is not 200 to 300
                    Log.d("onResponse", "Response Not Successful");
                    return;
                }
                Log.d("onResponse", "facility.toString()");
                for (SportFacility facility: response.body()) {
                    Log.d("onResponse", facility.getRemarks());
                }
            }
            @Override
            public void onFailure(Call<List<SportFacility>> call, Throwable t) {
                Log.d("onFailure", "Unknown Failure / Network Failure");
            }
        });
    }
}