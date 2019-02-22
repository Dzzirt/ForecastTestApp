package com.example.forecastcodesample.util;

public class Utils {

    private interface SimpleWindRose {
        String NORTH = "North";
        String WEST = "West";
        String SOUTH = "South";
        String EAST = "East";
        String NORTH_WEST = "North West";
        String NORTH_EAST = "North East";
        String SOUTH_EAST = "South East";
        String SOUTH_WEST = "South West";
        String UNKNOWN = "Unknown";
    }

    public static String degreeToDirection(int degree) {
        if (degree == 0) {
            return SimpleWindRose.NORTH;
        } else if (degree == 90) {
            return SimpleWindRose.EAST;
        } else if (degree == 180) {
            return SimpleWindRose.SOUTH;
        } else if (degree == 270) {
            return SimpleWindRose.WEST;
        } else if (degree > 0 && degree < 90) {
            return SimpleWindRose.NORTH_EAST;
        } else if (degree > 90 && degree < 180) {
            return SimpleWindRose.SOUTH_EAST;
        } else if (degree > 180 && degree < 270) {
            return SimpleWindRose.SOUTH_WEST;
        } else if (degree > 270 && degree < 360) {
            return SimpleWindRose.NORTH_WEST;
        } else {
            return SimpleWindRose.UNKNOWN;
        }
    }

}
