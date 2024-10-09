package edu.bu.met.cs665;

import org.apache.commons.lang3.RandomStringUtils;

public class Scooter implements Driver{

    String registrationNumber;

    public Scooter() {
        registrationNumber = RandomStringUtils.random(10, true, false);
    }
    @Override
    public void updateSelf(DeliveryRequest deliveryRequest) {
        if(deliveryRequest.getRequestDriverType() == DriverType.SCOOTER) {
            deliveryRequest.setDriverRegisterNumber(this.registrationNumber);
            beginToProcess(deliveryRequest);
        }
    }

    public void beginToProcess(DeliveryRequest deliveryRequest) {
        deliveryRequest.onTheWay();
        deliveryRequest.deliveryLogs.add("Scooter Driver begin to deal with order!");
        deliveryRequest.delivered();
        deliveryRequest.deliveryLogs.add("The request has been finished");
    }

    @Override
    public DriverType getDriverType() {
        return DriverType.SCOOTER;
    }

    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
