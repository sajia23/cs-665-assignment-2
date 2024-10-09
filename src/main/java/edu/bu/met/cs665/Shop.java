package edu.bu.met.cs665;

public class Shop implements PublisherBase{

    private RegistedDrivers registedDrivers;
    private static volatile Shop ns;
    private Shop() {
        registedDrivers = new RegistedDrivers();
    }
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
    @Override
    public void subscribe(SubscriberBase o) {
        Driver driver = (Driver) o;
        registedDrivers.registerDriver(driver);
    }

    @Override
    public void unsubscribe(String name) {

    }

    @Override
    public void unsubscribeAll() {
        registedDrivers.clearAll();
    }

    public RegistedDrivers getRegistedDrivers() {
        return registedDrivers;
    }

    public void placeTheOrder(DeliveryRequest deliveryRequest) {
        deliveryRequest.broadcastRequest();
        deliveryRequest.deliveryLogs.add("Begin to broadcast the request to drivers!");
        notifySubscribers(deliveryRequest);
    }

    @Override
    public void notifySubscribers(DeliveryRequest deliveryRequest) {
        DriversIterator driversIterator = registedDrivers.createIterator();
        while (driversIterator.hasNext()) {
            Driver driver = (Driver) driversIterator.next();
            driver.updateSelf(deliveryRequest);
        }
        if(deliveryRequest.getDriverRegisterNumber() == null) {
            deliveryRequest.deliveryLogs.add("No appropriate driver to do the job!");
        }
    }
}
