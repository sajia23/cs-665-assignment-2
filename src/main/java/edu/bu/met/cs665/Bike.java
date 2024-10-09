/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/08/2024
 * File Name: Bike.java
 * Description: This class is responsible for the processing the request from shop.
 */
package edu.bu.met.cs665;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * This class is responsible for the processing the request from shop.
 */
public class Bike implements Driver{

    String registrationNumber;

    /**
     * Construction method
     */
    public Bike() {
        registrationNumber = RandomStringUtils.random(10, true, false);
    }

    /**
     * Decide if the driver is appropriate to the request.
     * @Param deliveryRequest
     */
    @Override
    public void updateSelf(DeliveryRequest deliveryRequest) {
        if(deliveryRequest.getRequestDriverType() == DriverType.BIKE) {
            deliveryRequest.setDriverRegisterNumber(this.registrationNumber);
            beginToProcess(deliveryRequest);
        }
    }

    /**
     * Begin to process the request
     */
    public void beginToProcess(DeliveryRequest deliveryRequest) {
        deliveryRequest.onTheWay();
        deliveryRequest.deliveryLogs.add("Bike Driver begin to deal with order!");
        deliveryRequest.delivered();
        deliveryRequest.deliveryLogs.add("The request has been finished");
    }

    /**
     * Return type of the driver.
     */
    @Override
    public DriverType getDriverType() {
        return DriverType.BIKE;
    }

    /**
     * Return registration number of the driver.
     */
    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
