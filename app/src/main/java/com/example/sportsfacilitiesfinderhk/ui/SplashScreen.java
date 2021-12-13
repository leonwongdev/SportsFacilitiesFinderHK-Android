package com.example.sportsfacilitiesfinderhk.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.example.sportsfacilitiesfinderhk.R;
import com.example.sportsfacilitiesfinderhk.models.SportFacility;
import com.example.sportsfacilitiesfinderhk.network.APIHelper;
import com.example.sportsfacilitiesfinderhk.ui.MainActivity;
import com.example.sportsfacilitiesfinderhk.ui.facilitieslist.FacilitiesListActivity;
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

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                if (responseCount == 2) {
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                }
            }
        });

        APIHelper.sportsFacilitiesAPI().getArcheryRange().enqueue(new Callback<List<SportFacility>>() {
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

    }
}