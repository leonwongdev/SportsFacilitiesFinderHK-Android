package com.example.sportsfacilitiesfinderhk.models;

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
        if(numCourts == null){
            numCourts = "1";
        }
        return numCourts;
    }

    public String getAncillaryFacilities() {
        ancillaryFacilities = Html.fromHtml(ancillaryFacilities, Html.FROM_HTML_MODE_COMPACT).toString();
        return ancillaryFacilities;
    }

    public String getOpeningHours() {
        openingHours = Html.fromHtml(openingHours, Html.FROM_HTML_MODE_COMPACT).toString();
        return openingHours;
    }

    public String getPhone() {
        return phone;
    }

    public String getRemarks() {
        return Html.fromHtml(remarks, Html.FROM_HTML_MODE_COMPACT).toString();
    }

    public double getLongtitude() {
        String[] dms = longtitude.split("-",0);
        double lng = Double.parseDouble(dms[0]) + Double.parseDouble(dms[1])/60 + Double.parseDouble(dms[2])/3600;
        return lng;
    }

    public double getLatitude() {
        String[] dms = latitude.split("-",0);
        double lat = Double.parseDouble(dms[0]) + Double.parseDouble(dms[1])/60 + Double.parseDouble(dms[2])/3600;
        return lat;
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
