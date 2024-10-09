package edu.bu.met.cs665;

public interface Driver extends SubscriberBase {
    void beginToProcess(DeliveryRequest deliveryRequest);

    DriverType getDriverType();

    String getRegistrationNumber();
}
