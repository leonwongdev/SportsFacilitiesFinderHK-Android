package com.example.sportsfacilitiesfinderhk.utilities;

import com.example.sportsfacilitiesfinderhk.models.SportFacility;

import java.util.List;

public class DataManager {
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
