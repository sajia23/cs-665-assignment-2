package edu.bu.met.cs665;

import org.apache.commons.lang3.RandomStringUtils;

public class Car implements Driver{
    String registrationNumber;

    public Car() {
        registrationNumber = RandomStringUtils.random(10);
    }
    @Override
    public void updateSelf(DeliveryRequest deliveryRequest) {
        if(deliveryRequest.getRequestDriverType() == DriverType.CAR) {
            deliveryRequest.setDriverRegisterNumber(this.registrationNumber);
            beginToProcess(deliveryRequest);
        }
    }

    @Override
    public void beginToProcess(DeliveryRequest deliveryRequest) {
        deliveryRequest.onTheWay();
        deliveryRequest.deliveryLogs.add("Car Driver begin to deal with order!");
        deliveryRequest.delivered();
        deliveryRequest.deliveryLogs.add("The request has been finished");
    }
}
