package com.example.sportsfacilitiesfinderhk.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.sportsfacilitiesfinderhk.R;
import com.example.sportsfacilitiesfinderhk.adapters.SportsTypeRecViewAdapter;
import com.example.sportsfacilitiesfinderhk.models.SportFacility;
import com.example.sportsfacilitiesfinderhk.network.APIHelper;
import com.example.sportsfacilitiesfinderhk.utilities.AlertHelper;
import com.example.sportsfacilitiesfinderhk.utilities.GridSpacingItemDecoration;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

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



        if (checkGooglePlayServices()) {
            Toast.makeText(MainActivity.this, "Google play service available", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Google play service not available", Toast.LENGTH_SHORT).show();
        };
    }

    private boolean checkGooglePlayServices() {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int result = googleApiAvailability.isGooglePlayServicesAvailable(this);
        if (result == ConnectionResult.SUCCESS) {
            return true;
        } else if (googleApiAvailability.isUserResolvableError(result)){
            Dialog dialog = googleApiAvailability.getErrorDialog(this, result, 201, new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    Toast.makeText(MainActivity.this, "User Cancelled Dialog", Toast.LENGTH_SHORT).show();
                }
            });
            dialog.show();
        }
        return false;
    }
}

