package com.example.sportsfacilitiesfinderhk.utilities;

import com.example.sportsfacilitiesfinderhk.models.SportFacility;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    static String[] sportTypes = {"Archery","Beach Volleyball",
            "Cricket","Gateball","Handball","Netball","Roller Skating","Skateboarding"};

    static List<SportFacility> currentFacilityList;
    static List<SportFacility> handballCourts;
    static List<SportFacility> archeryRanges;
    static List<SportFacility> skateboardGrounds;
    static List<SportFacility> skateboardGrounds1;
    static List<SportFacility> skateboardGrounds2;
    static List<SportFacility> netballCourts;
    static List<SportFacility> beachVolleyballCourts;
    static List<SportFacility> rollerSkatingRinks;
    static List<SportFacility> gateballCourts;
    static List<SportFacility> cricketGrounds;
    static List<SportFacility> cricketGrounds1;
    static List<SportFacility> cricketGrounds2;
    static List<SportFacility> cricketGrounds3;

    public static List<SportFacility> getCurrentFacilityList() {
        return currentFacilityList;
    }

    public static void setCurrentFacilityList(List<SportFacility> currentFacilityList) {
        DataManager.currentFacilityList = currentFacilityList;
    }

    public static String[] getSportTypes() {
        return sportTypes;
    }

    public static List<SportFacility> getHandballCourts() {
        return handballCourts;
    }

    public static void setHandballCourts(List<SportFacility> handballCourts) {
        handballCourts = setType(handballCourts,"Handball");
        DataManager.handballCourts = handballCourts;
    }

    public static List<SportFacility> getArcheryRanges() {
        return archeryRanges;
    }

    public static void setArcheryRanges(List<SportFacility> archeryRanges) {

        DataManager.archeryRanges = setType(archeryRanges,"Archery");
    }

    public static List<SportFacility> getSkateboardGrounds() {
        return skateboardGrounds;
    }

    public static void setSkateboardGrounds(List<SportFacility> skateboardGrounds) {
        DataManager.skateboardGrounds = setType(skateboardGrounds,"Skateboarding");
    }

    public static List<SportFacility> getSkateboardGrounds1() {
        return skateboardGrounds1;
    }

    public static void setSkateboardGrounds1(List<SportFacility> skateboardCourts) {
        DataManager.skateboardGrounds1 = skateboardCourts;
    }

    public static List<SportFacility> getSkateboardGrounds2() {
        return skateboardGrounds2;
    }

    public static void setSkateboardGrounds2(List<SportFacility> skateboardGrounds2) {
        DataManager.skateboardGrounds2 = skateboardGrounds2;
    }

    public static List<SportFacility> getNetballCourts() {
        return netballCourts;
    }

    public static void setNetballCourts(List<SportFacility> netballCourts) {
        DataManager.netballCourts = setType(netballCourts,"Netball");
    }

    public static List<SportFacility> getBeachVolleyballCourts() {
        return beachVolleyballCourts;
    }

    public static void setBeachVolleyballCourts(List<SportFacility> beachVolleyballCourts) {
        DataManager.beachVolleyballCourts = setType(beachVolleyballCourts, "Beach Volleyball");
    }

    public static List<SportFacility> getRollerSkatingRinks() {
        return rollerSkatingRinks;
    }

    public static void setRollerSkatingRinks(List<SportFacility> rollerSkatingRinks) {
        DataManager.rollerSkatingRinks = setType(rollerSkatingRinks, "Roller Skating");
    }

    public static List<SportFacility> getGateballCourts() {
        return gateballCourts;
    }

    public static void setGateballCourts(List<SportFacility> gateballCourts) {
        DataManager.gateballCourts = setType(gateballCourts, "Gateball");
    }

    public static List<SportFacility> getCricketGrounds() {
        return cricketGrounds;
    }

    public static void setCricketGrounds(List<SportFacility> cricketGrounds) {
        DataManager.cricketGrounds = setType(cricketGrounds, "Cricket");
    }

    public static List<SportFacility> getCricketGrounds1() {
        return cricketGrounds1;
    }

    public static void setCricketGrounds1(List<SportFacility> cricketGrounds1) {
        DataManager.cricketGrounds1 = cricketGrounds1;
    }

    public static List<SportFacility> getCricketGrounds2() {
        return cricketGrounds2;
    }

    public static void setCricketGrounds2(List<SportFacility> cricketGrounds2) {
        DataManager.cricketGrounds2 = cricketGrounds2;
    }

    public static List<SportFacility> getCricketGrounds3() {
        return cricketGrounds3;
    }

    public static void setCricketGrounds3(List<SportFacility> cricketGrounds3) {
        DataManager.cricketGrounds3 = cricketGrounds3;
    }

    private static List<SportFacility> setType(List<SportFacility> sportFacilityList, String type) {
        for (SportFacility sportFac:
             sportFacilityList) {
            sportFac.setType(type);
        }
        return sportFacilityList;
    }
}
