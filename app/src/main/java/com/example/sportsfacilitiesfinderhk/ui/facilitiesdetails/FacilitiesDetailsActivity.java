package com.example.sportsfacilitiesfinderhk.ui.facilitiesdetails;

import androidx.appcompat.app.AppCompatActivity;
import com.example.sportsfacilitiesfinderhk.R;
import com.example.sportsfacilitiesfinderhk.models.SportFacility;
import com.example.sportsfacilitiesfinderhk.ui.direction.FacilityDirectionActivity;
import com.example.sportsfacilitiesfinderhk.utilities.DataManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
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
        get_directions_button = findViewById(R.id.get_directions_button);



        List<SportFacility> sportsFacility = DataManager.getCurrentFacilityList();
        index = getIntent().getIntExtra("index", 0);

        name_tv.setText(sportsFacility.get(index).getName());

        district_tv.setText(Html.fromHtml("<b>District:</b> " + sportsFacility.get(index).getDistrict(),Html.FROM_HTML_MODE_COMPACT));
        address_tv.setText(Html.fromHtml("<b>Address:</b> " + sportsFacility.get(index).getAddress(),Html.FROM_HTML_MODE_COMPACT));
        num_of_courts_tv.setText(Html.fromHtml("<b>Number of Courts:</b> " + sportsFacility.get(index).getNumCourts(),Html.FROM_HTML_MODE_COMPACT));
        ancillary_facilities_tv.setText(Html.fromHtml("<b>Ancillary Facilities:</b> " + sportsFacility.get(index).getAncillaryFacilities(),Html.FROM_HTML_MODE_COMPACT));
        phone_num_tv.setText(Html.fromHtml("<b>Phone Number:</b> " + sportsFacility.get(index).getPhone(),Html.FROM_HTML_MODE_COMPACT));
        opening_hours_tv.setText(Html.fromHtml("<b>Opening Hours:</b> " + sportsFacility.get(index).getOpeningHours(),Html.FROM_HTML_MODE_COMPACT));


        get_directions_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacilitiesDetailsActivity.this, FacilityDirectionActivity.class);
                intent.putExtra("index", index);
                startActivity(intent);
            }
        });


    }
}