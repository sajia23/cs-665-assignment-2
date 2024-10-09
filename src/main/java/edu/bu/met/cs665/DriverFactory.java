package edu.bu.met.cs665;

public class DriverFactory {
    public static Driver produceDriver(DriverType driverType) {
        switch(driverType) {
            case CAR:
                return new Car();
            case VAN:
                return new Van();
            case TAXI:
                return new Taxi();
            case SCOOTER:
                return new Scooter();
            case BIKE:
                return new Bike();
            default:
                break;
        }
        return null;
    }
}
