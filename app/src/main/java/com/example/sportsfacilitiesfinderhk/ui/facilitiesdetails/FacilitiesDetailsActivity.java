package com.example.sportsfacilitiesfinderhk.ui.facilitiesdetails;

import androidx.appcompat.app.AppCompatActivity;
import com.example.sportsfacilitiesfinderhk.R;
import com.example.sportsfacilitiesfinderhk.models.SportFacility;
import com.example.sportsfacilitiesfinderhk.utilities.DataManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class FacilitiesDetailsActivity extends AppCompatActivity {

    TextView name_tv;
    TextView district_tv;
    TextView address_tv;
    TextView description_tv;
    TextView num_of_courts_tv;
    TextView ancillary_facilities_tv;
    TextView phone_num_tv;
    TextView opening_hours_tv;
    TextView reviews_tv;
    Button get_directions_button;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities_details);


        name_tv = findViewById(R.id.name_tv);
        district_tv = findViewById(R.id.district_tv);
        address_tv = findViewById(R.id.address_tv);
        description_tv = findViewById(R.id.description_tv);
        num_of_courts_tv = findViewById(R.id.num_of_courts_tv);
        ancillary_facilities_tv = findViewById(R.id.ancillary_facilities_tv);
        phone_num_tv = findViewById(R.id.phone_num_tv);
        opening_hours_tv = findViewById(R.id.opening_hours_tv);
        reviews_tv = findViewById(R.id.reviews_tv);
        get_directions_button = findViewById(R.id.get_directions_button);



        List<SportFacility> sportsFacility = DataManager.getCurrentFacilityList();
        index = getIntent().getIntExtra("index", 0);

        name_tv.setText(sportsFacility.get(index).getName());
        district_tv.setText("District: " + sportsFacility.get(index).getDistrict());
        address_tv.setText("Address: " + sportsFacility.get(index).getAddress());
        num_of_courts_tv.setText("Number of Courts: " + sportsFacility.get(index).getNumCourts());
        ancillary_facilities_tv.setText("Ancillary Facilities: " + sportsFacility.get(index).getAncillaryFacilities());
        phone_num_tv.setText("Phone Number: " + sportsFacility.get(index).getPhone());
        opening_hours_tv.setText("Opening Hours: " + sportsFacility.get(index).getOpeningHours());


        get_directions_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}