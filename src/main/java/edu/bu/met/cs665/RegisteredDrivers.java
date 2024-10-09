/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/08/2024
 * File Name: RegisteredDrivers.java
 * Description: This class is responsible for the register driver and notify the request to every driver.
 */
package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;

public class RegisteredDrivers implements Drivers{

    List<Driver> drivers;

    /**
     * Construction method
     */
    public RegisteredDrivers() {
        drivers = new ArrayList<>();
    }

    /**
     * Register the driver into the system.
     * @Param driver
     */
    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    /**
     * Get a iterator of the registered drivers
     */
    @Override
    public DriversIterator createIterator() {
        return new DriversIterator(drivers);
    }

    /**
     * Clear all drivers in the system
     */
    public void clearAll() {
        drivers.clear();
    }
}
