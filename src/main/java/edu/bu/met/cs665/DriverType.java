/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/08/2024
 * File Name: DriverType.java
 * Description: This class is responsible for the register driver and notify the request to every driver.
 */
package edu.bu.met.cs665;

import org.apache.commons.lang3.RandomUtils;

public enum DriverType {
    VAN,
    TAXI,
    SCOOTER,
    CAR,
    BIKE;

    /**
     * Get a random driver type
     */
    public static DriverType randomDriverType() {
        int pick = RandomUtils.nextInt(0, 5);
        return DriverType.values()[pick];
    }
}
