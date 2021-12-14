package com.example.sportsfacilitiesfinderhk.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sportsfacilitiesfinderhk.R;
import com.example.sportsfacilitiesfinderhk.adapters.SportsTypeRecViewAdapter;
import com.example.sportsfacilitiesfinderhk.models.SportFacility;
import com.example.sportsfacilitiesfinderhk.network.APIHelper;
import com.example.sportsfacilitiesfinderhk.ui.facilitieslist.FacilitiesListActivity;
import com.example.sportsfacilitiesfinderhk.utilities.AlertHelper;
import com.example.sportsfacilitiesfinderhk.utilities.Constants;
import com.example.sportsfacilitiesfinderhk.utilities.DataManager;
import com.example.sportsfacilitiesfinderhk.utilities.GridSpacingItemDecoration;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView sportsTypeRecView;
    ArrayList<String> sports = new ArrayList<String>();
    Button bookmarkButton;
    boolean mLocationPermissionGranted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sportsTypeRecView = findViewById(R.id.sports_type_rec_view);
        SportsTypeRecViewAdapter sportsTypeRecViewAdapter = new SportsTypeRecViewAdapter(this, DataManager.getSportTypes());
        sportsTypeRecView.setAdapter(sportsTypeRecViewAdapter);
        sportsTypeRecView.setLayoutManager(new GridLayoutManager(this,2));
        sportsTypeRecView.addItemDecoration(new GridSpacingItemDecoration(2,25,true));
        sportsTypeRecView.setVisibility(View.GONE);

        bookmarkButton = findViewById(R.id.bookmark_button);
        bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();
                SharedPreferences appSharedPrefs = PreferenceManager
                        .getDefaultSharedPreferences(MainActivity.this.getApplicationContext());
                String json = appSharedPrefs.getString("bookmarks", "");
                if (json.equals("")) {
                    AlertHelper.showErrorAlert(MainActivity.this, "No Bookmarked Sport Facilities. Try adding one to the bookmark!");
                } else {
                    Intent intent = new Intent(MainActivity.this, FacilitiesListActivity.class);
                    intent.putExtra("sportsType", "bookmark");
                    intent.putExtra("isBookmarkPage", true);
                    MainActivity.this.startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(checkMapServices()){
            if(mLocationPermissionGranted){
                //TODO:ENABLE BUTTON
                sportsTypeRecView.setVisibility(View.VISIBLE);
            }
            else{
                getLocationPermission();
            }
        }
    }

    private boolean checkMapServices(){
        if(checkGooglePlayServices()){
            return isMapsEnabled();
        }
        return false;
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

    private void getLocationPermission() {
        /*
         * Request location permission, so that we can get the location of the
         * device. The result of the permission request is handled by a callback,
         * onRequestPermissionsResult.
         */
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionGranted = true;
            //TODO:ENABLE BUTTONS
            sportsTypeRecView.setVisibility(View.VISIBLE);
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    Constants.PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("TAG", "onActivityResult: called.");
        switch (requestCode) {
            case Constants.PERMISSIONS_REQUEST_ENABLE_GPS: {
                if(mLocationPermissionGranted){
                    //TODO: Enable buttons
                    sportsTypeRecView.setVisibility(View.VISIBLE);
                }
                else{
                    getLocationPermission();
                }
            }
        }
    }

    public boolean isMapsEnabled(){
        final LocationManager manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );

        if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
            buildAlertMessageNoGps();
            return false;
        }
        return true;
    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("This application requires GPS to work properly, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        Intent enableGpsIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivityForResult(enableGpsIntent, Constants.PERMISSIONS_REQUEST_ENABLE_GPS);
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }
}

