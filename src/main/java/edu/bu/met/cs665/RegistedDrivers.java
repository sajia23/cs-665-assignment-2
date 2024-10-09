package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;

public class RegistedDrivers implements Drivers{

    List<Driver> drivers;

    public RegistedDrivers() {
        drivers = new ArrayList<>();
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }
    @Override
    public DriversIterator createIterator() {
        return new DriversIterator(drivers);
    }

    public void clearAll() {
        drivers.clear();
    }
}
