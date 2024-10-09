package edu.bu.met.cs665;

import org.apache.commons.lang3.RandomStringUtils;

public class Van implements Driver{

    String registrationNumber;

    public Van() {
        registrationNumber = RandomStringUtils.random(10, true, false);
    }
    @Override
    public void updateSelf(DeliveryRequest deliveryRequest) {
        if(deliveryRequest.getRequestDriverType() == DriverType.VAN) {
            deliveryRequest.setDriverRegisterNumber(this.registrationNumber);
            beginToProcess(deliveryRequest);
        }
    }

    public void beginToProcess(DeliveryRequest deliveryRequest) {
        deliveryRequest.onTheWay();
        deliveryRequest.deliveryLogs.add("Van Driver begin to deal with order!");
        deliveryRequest.delivered();
        deliveryRequest.deliveryLogs.add("The request has been finished");
    }

    @Override
    public DriverType getDriverType() {
        return DriverType.VAN;
    }

    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
