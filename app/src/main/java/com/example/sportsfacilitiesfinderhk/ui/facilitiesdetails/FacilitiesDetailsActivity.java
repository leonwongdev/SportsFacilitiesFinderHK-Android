package com.example.sportsfacilitiesfinderhk.ui.facilitiesdetails;

import androidx.appcompat.app.AppCompatActivity;
import com.example.sportsfacilitiesfinderhk.R;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class FacilitiesDetailsActivity extends AppCompatActivity {

    TextView intro_tv;
    TextView description_tv;
    TextView reviews_tv;
    Button get_directions_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities_details);

        intro_tv = findViewById(R.id.intro_tv);
        description_tv = findViewById(R.id.description_tv);
        reviews_tv = findViewById(R.id.reviews_tv);
        get_directions_button = findViewById(R.id.get_directions_button);




    }
}