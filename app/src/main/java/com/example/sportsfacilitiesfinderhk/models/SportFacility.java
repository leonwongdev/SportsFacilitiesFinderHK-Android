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

    String type;

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGIHS(String GIHS) {
        this.GIHS = GIHS;
    }

    public void setNumCourts(String numCourts) {
        this.numCourts = numCourts;
    }

    public void setAncillaryFacilities(String ancillaryFacilities) {
        this.ancillaryFacilities = ancillaryFacilities;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public SportFacility() {
        this.district = "district";
        this.name = "Tuen Mun Recreation and Sports Centre Archery Range";
        this.address = "address";
        this.GIHS = "GIHS";
        this.numCourts = "numCourts";
        this.ancillaryFacilities = "ancillaryFacilities";
        this.openingHours = "openingHours";
        this.phone = "phone";
        this.remarks = "remarks";
        this.longtitude = "113-57-37";
        this.latitude = "22-22-37";
        this.type = "type";
    }

    public SportFacility(String district, String name, String address, String GIHS, String numCourts, String ancillaryFacilities, String openingHours, String phone, String remarks, String longtitude, String latitude, String type) {
        this.district = district;
        this.name = name;
        this.address = address;
        this.GIHS = "Qjfsw8KfZE";
        this.numCourts = numCourts;
        this.ancillaryFacilities = ancillaryFacilities;
        this.openingHours = openingHours;
        this.phone = phone;
        this.remarks = remarks;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getDistrict() {
        return checkNull(district);
    }

    public String getName() {

        name = Html.fromHtml(checkNull(name), Html.FROM_HTML_MODE_COMPACT).toString();
        return name;
    }

    public String getAddress() {
        return checkNull(address);
    }

    public String getGIHS() {
        return checkNull(GIHS);
    }

    public String getNumCourts() {
        if(numCourts == null){
            numCourts = "1";
        }
        return numCourts;
    }

    public String getAncillaryFacilities() {
        ancillaryFacilities = Html.fromHtml(checkNull(ancillaryFacilities), Html.FROM_HTML_MODE_COMPACT).toString();
        return ancillaryFacilities;
    }

    public String getOpeningHours() {
        openingHours = Html.fromHtml(checkNull(openingHours), Html.FROM_HTML_MODE_COMPACT).toString();
        return openingHours;
    }

    public String getPhone() {
        return checkNull(phone);
    }

    public String getRemarks() {
        return Html.fromHtml(checkNull(remarks), Html.FROM_HTML_MODE_COMPACT).toString();
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

    private String checkNull(String input) {
        if (input == null) {
            return "N/A";
        } else {
            return input;
        }
    }
}
