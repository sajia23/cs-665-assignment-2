/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/08/2024
 * File Name: Driver.java
 * Description: This interface defines method of Driver
 */
package edu.bu.met.cs665;

public interface Driver extends SubscriberBase {
    void beginToProcess(DeliveryRequest deliveryRequest);

    DriverType getDriverType();

    String getRegistrationNumber();
}
