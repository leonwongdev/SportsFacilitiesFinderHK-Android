package com.example.sportsfacilitiesfinderhk.model;

import android.text.Html;

import com.google.gson.annotations.SerializedName;

public class SportFacility {
    @SerializedName("District_en")
    String district;

    @SerializedName("Name_en")
    String name;

    @SerializedName("Address_en")
    String address;

    @SerializedName("GIHS")
    String GIHS;

    @SerializedName("Court_no_en")
    String numCourts;

    @SerializedName("Ancillary_facilities_en")
    String ancillaryFacilities;

    @SerializedName("Opening_hours_en")
    String openingHours;

    @SerializedName("Phone")
    String phone;

    @SerializedName("Remarks_en")
    String remarks;

    @SerializedName("Longitude")
    String longtitude;

    @SerializedName("Latitude")
    String latitude;

    public String getDistrict() {
        return district;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getGIHS() {
        return GIHS;
    }

    public String getNumCourts() {
        return numCourts;
    }

    public String getAncillaryFacilities() {
        ancillaryFacilities = Html.fromHtml(ancillaryFacilities,Html.FROM_HTML_MODE_COMPACT).toString();
        return ancillaryFacilities;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public String getPhone() {
        return phone;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public String getLatitude() {
        return latitude;
    }

    @Override
    public String toString() {
        return "SportFacility{" +
                "district='" + district + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", GIHS='" + GIHS + '\'' +
                ", numCourts='" + numCourts + '\'' +
                ", ancillaryFacilities='" + ancillaryFacilities + '\'' +
                ", openingHours='" + openingHours + '\'' +
                ", phone='" + phone + '\'' +
                ", remarks='" + remarks + '\'' +
                ", longtitude='" + longtitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
