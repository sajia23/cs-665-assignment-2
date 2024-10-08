package edu.bu.met.cs665;

public class NotificationSystem implements PublisherBase{

    private RegistedDrivers registedDrivers;
    private static volatile NotificationSystem ns;
    private NotificationSystem() {
        registedDrivers = new RegistedDrivers();
    }
    private static void getInstance() {
        if(ns == null) {
            synchronized (NotificationSystem.class) {
                if(ns == null) {
                    ns = new NotificationSystem();
                }
            }
        }
    }
    @Override
    public void subscribe(SubscriberBase o) {
        Driver driver = (Driver) o;
        registedDrivers.registerDriver(driver);
    }

    @Override
    public void unsubscribe(String name) {

    }

    public void unsubscribeAll() {
        registedDrivers.clearAll();
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
            deliveryRequest.deliveryLogs.add("Begin to broadcast the request to drivers!");
        }
    }
}
