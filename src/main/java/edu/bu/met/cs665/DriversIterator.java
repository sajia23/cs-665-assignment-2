package edu.bu.met.cs665;

import java.util.List;

public class DriversIterator implements Iterator {
    List<Driver> drivers;
    int index = 0;

    public DriversIterator(List<Driver> drivers) {
        index = 0;
        this.drivers = drivers;
    }
    @Override
    public boolean hasNext() {
        if (index >= drivers.size() || drivers.get(index) == null ) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        return drivers.get(index++);
    }
}
