/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/08/2024
 * File Name: DriverIterator.java
 * Description: This class is responsible for the register driver and notify the request to every driver.
 */
package edu.bu.met.cs665;

import java.util.List;

public class DriversIterator implements Iterator {
    List<Driver> drivers;
    int index = 0;

    /**
     * Construction method
     */
    public DriversIterator(List<Driver> drivers) {
        index = 0;
        this.drivers = drivers;
    }

    /**
     * Check if there is a next element.
     */
    @Override
    public boolean hasNext() {
        if (index >= drivers.size() || drivers.get(index) == null ) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Get next element
     */
    @Override
    public Object next() {
        return drivers.get(index++);
    }
}
