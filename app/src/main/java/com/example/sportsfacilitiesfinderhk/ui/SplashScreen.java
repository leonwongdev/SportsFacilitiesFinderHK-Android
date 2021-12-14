//# COMP 4521    #  TO, Kai Yuen 20410782 kytoac@connect.ust.hk
//# COMP 4521    #  WONG, Lap Wong 20602036 lwwongaf@connect.ust.hk

package com.example.sportsfacilitiesfinderhk.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.example.sportsfacilitiesfinderhk.R;
import com.example.sportsfacilitiesfinderhk.models.SportFacility;
import com.example.sportsfacilitiesfinderhk.network.APIHelper;
import com.example.sportsfacilitiesfinderhk.utilities.AlertHelper;
import com.example.sportsfacilitiesfinderhk.utilities.DataManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;
    int responseCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        lottieAnimationView = findViewById(R.id.lottie_splash_ani_view);
        lottieAnimationView.setSpeed(3);
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                if (responseCount >= 8) {
                    lottieAnimationView.cancelAnimation();
                }
            }
        });

        if (!isNetworkAvailable(SplashScreen.this)) {
            AlertHelper.showErrorAlert(SplashScreen.this, "No internet connections, please check your network.");
            return;
        }
        
        APIHelper.sportsFacilitiesAPI().getArcheryRanges().enqueue(new Callback<List<SportFacility>>() {
            @Override
            public void onResponse(Call<List<SportFacility>> call, Response<List<SportFacility>> response) {
                if (!response.isSuccessful()) {
                    //HTTP status is not 200 to 300
                    AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data from DATA.GOV.HK.");
                    return;
                }
                DataManager.setArcheryRanges(response.body());
                responseCount++;
            }

            @Override
            public void onFailure(Call<List<SportFacility>> call, Throwable t) {
                AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data. Please check your network.");
            }
        });

        APIHelper.sportsFacilitiesAPI().getHandballCourts().enqueue(new Callback<List<SportFacility>>() {
            @Override
            public void onResponse(Call<List<SportFacility>> call, Response<List<SportFacility>> response) {
                if (!response.isSuccessful()) {
                    //HTTP status is not 200 to 300
                    AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data from DATA.GOV.HK.");
                    return;
                }
                DataManager.setHandballCourts(response.body());
                responseCount++;
            }

            @Override
            public void onFailure(Call<List<SportFacility>> call, Throwable t) {
                AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data. Please check your network.");
            }
        });

        APIHelper.sportsFacilitiesAPI().getSkateboardGrounds1().enqueue(new Callback<List<SportFacility>>() {
            @Override
            public void onResponse(Call<List<SportFacility>> call, Response<List<SportFacility>> response) {
                if (!response.isSuccessful()) {
                    //HTTP status is not 200 to 300
                    AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data from DATA.GOV.HK.");
                    return;
                }
                DataManager.setSkateboardGrounds1(response.body());
                responseCount++;
            }

            @Override
            public void onFailure(Call<List<SportFacility>> call, Throwable t) {
                AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data. Please check your network.");
            }
        });

        APIHelper.sportsFacilitiesAPI().getSkateboardGrounds2().enqueue(new Callback<List<SportFacility>>() {
            @Override
            public void onResponse(Call<List<SportFacility>> call, Response<List<SportFacility>> response) {
                if (!response.isSuccessful()) {
                    //HTTP status is not 200 to 300
                    AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data from DATA.GOV.HK.");
                    return;
                }
                DataManager.setSkateboardGrounds2(response.body());
                responseCount++;
            }

            @Override
            public void onFailure(Call<List<SportFacility>> call, Throwable t) {
                AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data. Please check your network.");
            }
        });

        APIHelper.sportsFacilitiesAPI().getNetballCourts().enqueue(new Callback<List<SportFacility>>() {
            @Override
            public void onResponse(Call<List<SportFacility>> call, Response<List<SportFacility>> response) {
                if (!response.isSuccessful()) {
                    //HTTP status is not 200 to 300
                    AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data from DATA.GOV.HK.");
                    return;
                }
                DataManager.setNetballCourts(response.body());
                responseCount++;
            }

            @Override
            public void onFailure(Call<List<SportFacility>> call, Throwable t) {
                AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data. Please check your network.");
            }
        });

        APIHelper.sportsFacilitiesAPI().getBeachVolleyballCourts().enqueue(new Callback<List<SportFacility>>() {
            @Override
            public void onResponse(Call<List<SportFacility>> call, Response<List<SportFacility>> response) {
                if (!response.isSuccessful()) {
                    //HTTP status is not 200 to 300
                    AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data from DATA.GOV.HK.");
                    return;
                }
                DataManager.setBeachVolleyballCourts(response.body());
                responseCount++;
            }

            @Override
            public void onFailure(Call<List<SportFacility>> call, Throwable t) {
                AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data. Please check your network.");
            }
        });

        APIHelper.sportsFacilitiesAPI().getGateballCourts().enqueue(new Callback<List<SportFacility>>() {
            @Override
            public void onResponse(Call<List<SportFacility>> call, Response<List<SportFacility>> response) {
                if (!response.isSuccessful()) {
                    //HTTP status is not 200 to 300
                    AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data from DATA.GOV.HK.");
                    return;
                }
                DataManager.setGateballCourts(response.body());
                responseCount++;
            }

            @Override
            public void onFailure(Call<List<SportFacility>> call, Throwable t) {
                AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data. Please check your network.");
            }
        });

        APIHelper.sportsFacilitiesAPI().getRollerSkatingRinks().enqueue(new Callback<List<SportFacility>>() {
            @Override
            public void onResponse(Call<List<SportFacility>> call, Response<List<SportFacility>> response) {
                if (!response.isSuccessful()) {
                    //HTTP status is not 200 to 300
                    AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data from DATA.GOV.HK.");
                    return;
                }
                DataManager.setRollerSkatingRinks(response.body());
                responseCount++;
            }

            @Override
            public void onFailure(Call<List<SportFacility>> call, Throwable t) {
                AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data. Please check your network.");
            }
        });

        APIHelper.sportsFacilitiesAPI().getCricketGrounds1().enqueue(new Callback<List<SportFacility>>() {
            @Override
            public void onResponse(Call<List<SportFacility>> call, Response<List<SportFacility>> response) {
                if (!response.isSuccessful()) {
                    //HTTP status is not 200 to 300
                    AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data from DATA.GOV.HK.");
                    return;
                }
                DataManager.setCricketGrounds1(response.body());
                responseCount++;
            }

            @Override
            public void onFailure(Call<List<SportFacility>> call, Throwable t) {
                AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data. Please check your network.");
            }
        });

        APIHelper.sportsFacilitiesAPI().getCricketGrounds2().enqueue(new Callback<List<SportFacility>>() {
            @Override
            public void onResponse(Call<List<SportFacility>> call, Response<List<SportFacility>> response) {
                if (!response.isSuccessful()) {
                    //HTTP status is not 200 to 300
                    AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data from DATA.GOV.HK.");
                    return;
                }
                DataManager.setCricketGrounds2(response.body());
                responseCount++;
            }

            @Override
            public void onFailure(Call<List<SportFacility>> call, Throwable t) {
                AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data. Please check your network.");
            }
        });

        APIHelper.sportsFacilitiesAPI().getCricketGrounds3().enqueue(new Callback<List<SportFacility>>() {
            @Override
            public void onResponse(Call<List<SportFacility>> call, Response<List<SportFacility>> response) {
                if (!response.isSuccessful()) {
                    //HTTP status is not 200 to 300
                    AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data from DATA.GOV.HK.");
                    return;
                }
                DataManager.setCricketGrounds3(response.body());
                responseCount++;
            }

            @Override
            public void onFailure(Call<List<SportFacility>> call, Throwable t) {
                AlertHelper.showErrorAlert(SplashScreen.this, "Error retrieving data. Please check your network.");
            }
        });

    }

    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}