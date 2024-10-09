/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/08/2024
 * File Name: DoneState.java
 * Description: This class represent current request status.
 */
package edu.bu.met.cs665;

public class DoneState implements State {

    DeliveryRequest deliveryRequest;

    /**
     * Construction method
     */
    public DoneState(DeliveryRequest deliveryRequest) {
        this.deliveryRequest = deliveryRequest;
    }

    /**
     * Define what should do when system broadcast the request.
     */
    @Override
    public void broadcastRequest() {
        System.out.println("You cannot broadcast the request while it is done!");
    }

    /**
     * Define what should do when request is on the way.
     */
    @Override
    public void onTheWay() {
        System.out.println("You cannot broadcast the request while it is done!");
    }

    /**
     * Define what should do when request is finished.
     */
    @Override
    public void delivered() {
        System.out.println("You cannot broadcast the request while it is done!");
    }
}
