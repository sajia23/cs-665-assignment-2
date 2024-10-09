package edu.bu.met.cs665;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.Iterator;

public class Taxi implements Driver{

    String registrationNumber;

    public Taxi() {
        registrationNumber = RandomStringUtils.random(10, true, false);
    }
    @Override
    public void updateSelf(DeliveryRequest deliveryRequest) {
        if(deliveryRequest.getRequestDriverType() == DriverType.TAXI) {
            deliveryRequest.setDriverRegisterNumber(this.registrationNumber);
            beginToProcess(deliveryRequest);
        }
    }

    public void beginToProcess(DeliveryRequest deliveryRequest) {
        deliveryRequest.onTheWay();
        deliveryRequest.deliveryLogs.add("Taxi Driver begin to deal with order!");
        deliveryRequest.delivered();
        deliveryRequest.deliveryLogs.add("The request has been finished");
    }

    @Override
    public DriverType getDriverType() {
        return DriverType.TAXI;
    }

    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
