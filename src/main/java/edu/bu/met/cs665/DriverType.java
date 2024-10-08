package edu.bu.met.cs665;

import org.apache.commons.lang3.RandomUtils;

public enum DriverType {
    VAN,
    TAXI,
    SCOOTER,
    CAR,
    BIKE;

    //private static Map<DriverType>
    public static DriverType randomDriverType() {
        int pick = RandomUtils.nextInt(0, 5);
        return DriverType.values()[pick];
    }
//    public static void initiateDriverTypeMap() {
//
//    }
}
