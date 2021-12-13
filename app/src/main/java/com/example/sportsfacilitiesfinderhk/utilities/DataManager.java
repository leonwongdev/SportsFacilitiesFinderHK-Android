package com.example.sportsfacilitiesfinderhk.utilities;

import com.example.sportsfacilitiesfinderhk.models.SportFacility;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    static String[] sportTypes = {"Football","Basketball",
            "Handball","Archery","Netball","Gateball","Cricket","Volleyball"};

    static List<SportFacility> currentFacilityList;

    public static List<SportFacility> getCurrentFacilityList() {
        return currentFacilityList;
    }

    public static void setCurrentFacilityList(List<SportFacility> currentFacilityList) {
        DataManager.currentFacilityList = currentFacilityList;
    }

    public static String[] getSportTypes() {
        return sportTypes;
    }

    static List<SportFacility> handballCourts;

    public static List<SportFacility> getHandballCourts() {
        return handballCourts;
    }

    public static void setHandballCourts(List<SportFacility> handballCourts) {
        DataManager.handballCourts = handballCourts;
    }

    static List<SportFacility> archeryRanges;

    public static List<SportFacility> getArcheryRanges() {
        return archeryRanges;
    }

    public static void setArcheryRanges(List<SportFacility> archeryRanges) {
        DataManager.archeryRanges = archeryRanges;
    }
}
