/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/08/2024
 * File Name: Shop.java
 * Description: This class is responsible for the register driver and notify the request to every driver.
 */
package edu.bu.met.cs665;

/**
 * This class is responsible for the register driver and notify the request to every driver.
 */
public class Shop implements PublisherBase{

    private RegisteredDrivers registeredDrivers;
    private static volatile Shop ns;

    /**
     * Construction method
     */
    private Shop() {
        registeredDrivers = new RegisteredDrivers();
    }

    /**
     * Get a singleton instance.
     */
    public static Shop getInstance() {
        if(ns == null) {
            synchronized (Shop.class) {
                if(ns == null) {
                    ns = new Shop();
                }
            }
        }
        return ns;
    }

    /**
     * Register the driver into the system.
     * @Param SubscriberBase interface
     */
    @Override
    public void subscribe(SubscriberBase o) {
        Driver driver = (Driver) o;
        registeredDrivers.registerDriver(driver);
    }

    /**
     * Get rid of every driver in the system.
     */
    @Override
    public void unsubscribeAll() {
        registeredDrivers.clearAll();
    }

    /**
     * Get registered drivers list in the system.
     */
    public RegisteredDrivers getRegistedDrivers() {
        return registeredDrivers;
    }

    /**
     * Submit the request to the system.
     * @Param deliveryRequest
     */
    public void placeTheOrder(DeliveryRequest deliveryRequest) {
        deliveryRequest.broadcastRequest();
        deliveryRequest.deliveryLogs.add("Begin to broadcast the request to drivers!");
        notifySubscribers(deliveryRequest);
    }

    /**
     * Notify every driver in the system to check availability.
     * @Param deliveryRequest
     */
    @Override
    public void notifySubscribers(DeliveryRequest deliveryRequest) {
        DriversIterator driversIterator = registeredDrivers.createIterator();
        while (driversIterator.hasNext()) {
            Driver driver = (Driver) driversIterator.next();
            driver.updateSelf(deliveryRequest);
        }
        if(deliveryRequest.getDriverRegisterNumber() == null) {
            deliveryRequest.deliveryLogs.add("No appropriate driver to do the job!");
        }
    }
}
