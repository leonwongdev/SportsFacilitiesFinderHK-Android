package com.example.sportsfacilitiesfinderhk.ui.facilitieslist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportsfacilitiesfinderhk.R;
import com.example.sportsfacilitiesfinderhk.adapters.FacilitiesListAdapter;
import com.example.sportsfacilitiesfinderhk.models.SportFacility;
import com.example.sportsfacilitiesfinderhk.network.APIHelper;
import com.example.sportsfacilitiesfinderhk.ui.MainActivity;
import com.example.sportsfacilitiesfinderhk.ui.facilitiesdetails.FacilitiesDetailsActivity;
import com.example.sportsfacilitiesfinderhk.utilities.AlertHelper;
import com.example.sportsfacilitiesfinderhk.utilities.DataManager;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FacilitiesListActivity extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap map;
    RecyclerView facilitiesRecView;
    private static final int REQUEST_LOCATION_PERMISSION = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities_list_activity);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.facilities_map_fragment);

        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
        facilitiesRecView = findViewById(R.id.facilities_list_recycler_view);
        facilitiesRecView.setAdapter(new FacilitiesListAdapter(FacilitiesListActivity.this,
                getFacilityType()));
        facilitiesRecView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        map.getUiSettings().setZoomControlsEnabled(true);
        List<SportFacility> sportFacilities = getFacilityType();
        for (int i = 0; i < sportFacilities.size(); i++) {
            LatLng marker = new LatLng(sportFacilities.get(i).getLatitude(),sportFacilities.get(i).getLongtitude());
            map.addMarker(new MarkerOptions().position(marker).title(sportFacilities.get(i).getName()));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(marker,12.0f));
        }
        map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(@NonNull Marker marker) {
                for (int i = 0; i < sportFacilities.size(); i++) {
                    if(marker.getTitle().equals(sportFacilities.get(i).getName())){
                        Intent intent = new Intent(FacilitiesListActivity.this, FacilitiesDetailsActivity.class);
                        intent.putExtra("index", i);
                        startActivity(intent);
                    }
                }
            }
        });
        enableMyLocation(map);
    }

    private List<SportFacility> getFacilityType(){

        switch(getIntent().getStringExtra("sportsType")){
            case "Football":
               // DataManager.setCurrentFacilityList(DataManager.);
                break;
            case "Handball":
                DataManager.setCurrentFacilityList(DataManager.getHandballCourts());
                break;
            case "Archery":
                DataManager.setCurrentFacilityList(DataManager.getArcheryRanges());
                break;
            case "ad":

                break;
            case "adf":

                break;
            case "adfg":

                break;
            case "asdfg":

                break;
            case "asdghgh":

                break;

        }

        return DataManager.getCurrentFacilityList();


    }

    /**
     * Checks for location permissions, and requests them if they are missing.
     * Otherwise, enables the location layer.
     */
    private void enableMyLocation(GoogleMap map) {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            map.setMyLocationEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this, new String[]
                            {Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION);
        }
    }
}