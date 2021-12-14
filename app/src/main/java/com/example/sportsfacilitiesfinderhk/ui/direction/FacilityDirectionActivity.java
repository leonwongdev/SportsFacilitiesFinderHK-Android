//# COMP 4521    #  TO, Kai Yuen 20410782 kytoac@connect.ust.hk
//# COMP 4521    #  WONG, Lap Wong 20602036 lwwongaf@connect.ust.hk

package com.example.sportsfacilitiesfinderhk.ui.direction;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.sportsfacilitiesfinderhk.R;
import com.example.sportsfacilitiesfinderhk.models.RouteData;
import com.example.sportsfacilitiesfinderhk.models.SportFacility;
import com.example.sportsfacilitiesfinderhk.utilities.DataManager;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.PendingResult;
import com.google.maps.internal.PolylineEncoding;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class FacilityDirectionActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnPolylineClickListener {
    GoogleMap map;
    FusedLocationProviderClient fusedLocationProviderClient;
    GeoApiContext geoApiContext;
    ArrayList<RouteData> routeDataArrayList = new ArrayList<>();
    Marker prevMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_direction);

        setUpMapFragment();
        setUpLocationService();
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        map = googleMap;
        map.getUiSettings().setZoomControlsEnabled(true);

        int index = getIntent().getIntExtra("index",0);
        SportFacility sportFac = DataManager.getCurrentFacilityList().get(index);
        LatLng latlng = new LatLng(sportFac.getLatitude(), sportFac.getLongtitude());
        prevMarker = map.addMarker(new MarkerOptions().position(latlng).title(sportFac.getName()));
        map.setMyLocationEnabled(true);
        addPathToMap(sportFac);

        map.setOnPolylineClickListener(this);

        if (geoApiContext == null) {
            geoApiContext = new GeoApiContext.Builder().apiKey(getString(R.string.map_key)).build();
        }
    }

    private void calculateDirections(SportFacility dst, Location userLocation){
        Log.d("TAG", "calculateDirections: calculating directions.");

        com.google.maps.model.LatLng destination = new com.google.maps.model.LatLng(
                dst.getLatitude(),
                dst.getLongtitude()
        );
        DirectionsApiRequest directions = new DirectionsApiRequest(geoApiContext);

        directions.alternatives(true);
        directions.origin(
                new com.google.maps.model.LatLng(
                        userLocation.getLatitude(),
                        userLocation.getLongitude()
                )
        );
        Log.d("TAG", "calculateDirections: destination: " + destination.toString());
        directions.destination(destination).setCallback(new PendingResult.Callback<DirectionsResult>() {
            @Override
            public void onResult(DirectionsResult result) {
                Log.d("TAG", "onResult: routes: " + result.routes[0].toString());
                Log.d("TAG", "onResult: geocodedWayPoints: " + result.geocodedWaypoints[0].toString());
                addPolylinesToMap(result);
            }

            @Override
            public void onFailure(Throwable e) {
                Log.e("TAG", "onFailure: " + e.getMessage() );

            }
        });
    }

    private void addPolylinesToMap(final DirectionsResult result){
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Log.d("TAG", "run: result routes: " + result.routes.length);

                if(routeDataArrayList !=null && routeDataArrayList.size() > 0) {
                    for (RouteData routeData:
                            routeDataArrayList) {
                        routeData.getPolyline().remove();
                    }
                    routeDataArrayList.clear();
                    routeDataArrayList = new ArrayList<>();
                }

                double duration = 999999999;
                Polyline fastestRoute = null;
                for(DirectionsRoute route: result.routes){
                    Log.d("TAG", "run: leg: " + route.legs[0].toString());
                    List<com.google.maps.model.LatLng> decodedPath = PolylineEncoding.decode(route.overviewPolyline.getEncodedPath());

                    List<LatLng> newDecodedPath = new ArrayList<>();

                    // This loops through all the LatLng coordinates of ONE polyline.
                    for(com.google.maps.model.LatLng latLng: decodedPath){
                        newDecodedPath.add(new LatLng(
                                latLng.lat,
                                latLng.lng
                        ));
                    }
                    Polyline polyline = map.addPolyline(new PolylineOptions().addAll(newDecodedPath));
                    polyline.setColor(ContextCompat.getColor(FacilityDirectionActivity.this, R.color.black));
                    polyline.setClickable(true);

                    double tempDuration = route.legs[0].duration.inSeconds;
                    if(tempDuration < duration){
                        duration = tempDuration;
                        fastestRoute = polyline;
                    }
                    routeDataArrayList.add(new RouteData(polyline, route.legs[0]));
                }
                if (fastestRoute != null) {
//                    fastestRoute.setColor(ContextCompat.getColor(FacilityDirectionActivity.this, R.color.teal_200));
//                    fastestRoute.setZIndex(1);
                   onPolylineClick(fastestRoute);
                }
            }
        });
    }

    private void setUpMapFragment() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.facility_direction_map_fragment);

        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    private void setUpLocationService() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
    }

    private void addPathToMap(SportFacility sportFacility) {
        Log.d("TAG", "getLastKnownLocation: called.");

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                if (task.isSuccessful()) {
                    Location location = task.getResult();
                    if (location != null) {
                        LatLng latlng = new LatLng(location.getLatitude(),location.getLongitude());
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng,12.0f));
                        calculateDirections(sportFacility, location);
                    }
                }
            }
        });
    }


    @Override
    public void onPolylineClick(@NonNull Polyline polyline) {
        int index = 0;
        for (RouteData routeData:
                routeDataArrayList) {
            index++;
            Log.d("TAG", "onPolylineClick: clicked Line:"+ polyline.getId() + " loopingLine:" + routeData.getPolyline().getId());
            if (polyline.getId().equals(routeData.getPolyline().getId())) {
                routeData.getPolyline().setColor(ContextCompat.getColor(FacilityDirectionActivity.this, R.color.teal_200));
                routeData.getPolyline().setZIndex(1);

                LatLng endLocation = new LatLng(
                        routeData.getLeg().endLocation.lat,
                        routeData.getLeg().endLocation.lng
                );
                prevMarker.remove();
                prevMarker = map.addMarker(new MarkerOptions()
                        .position(endLocation)
                        .title("Route #" + index)
                        .snippet("Duration (Driving): " + routeData.getLeg().duration
                        ));


                if (prevMarker != null) {
                    prevMarker.showInfoWindow();
                }
            } else {
                routeData.getPolyline().setColor(ContextCompat.getColor(FacilityDirectionActivity.this, R.color.black));
                routeData.getPolyline().setZIndex(0);
            }
        }

    }
}