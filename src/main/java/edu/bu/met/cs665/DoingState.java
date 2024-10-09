/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/08/2024
 * File Name: DoingState.java
 * Description: This class represent current request status.
 */
package edu.bu.met.cs665;

public class DoingState implements State {

    DeliveryRequest deliveryRequest;

    /**
     * Construction method
     */
    public DoingState(DeliveryRequest deliveryRequest) {
        this.deliveryRequest = deliveryRequest;
    }

    /**
     * Define what should do when system broadcast the request.
     */
    @Override
    public void broadcastRequest() {
        System.out.println("You cannot broadcast the request while it is on the way!");
    }

    /**
     * Define what should do when request is on the way.
     */
    @Override
    public void onTheWay() {
        System.out.println("You cannot deliver while it is on the way!");
    }

    /**
     * Define what should do when request is finished.
     */
    @Override
    public void delivered() {
        this.deliveryRequest.setState(deliveryRequest.getDoneState());
    }
}
