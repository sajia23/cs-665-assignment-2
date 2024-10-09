/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/08/2024
 * File Name: PublisherBase.java
 * Description: This interface defines methods for publisher role
 */
package edu.bu.met.cs665;

public interface PublisherBase {
    void subscribe(SubscriberBase o);

    void unsubscribeAll();

    void notifySubscribers(DeliveryRequest deliveryRequest);
}
