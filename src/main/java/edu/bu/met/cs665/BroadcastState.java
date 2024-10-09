/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/08/2024
 * File Name: BroadcastState.java
 * Description: This class represent current request status.
 */
package edu.bu.met.cs665;

public class BroadcastState implements State {

    DeliveryRequest deliveryRequest;

    /**
     * Construction method
     */
    public BroadcastState(DeliveryRequest deliveryRequest) {
        this.deliveryRequest = deliveryRequest;
    }

    /**
     * Define what should do when system broadcast the request.
     */
    @Override
    public void broadcastRequest() {
        System.out.println("You cannot broadcast a request  the request while it is being broadcasted!");
    }

    /**
     * Define what should do when request is on the way.
     */
    @Override
    public void onTheWay() {
        this.deliveryRequest.setState(deliveryRequest.getDoingState());
    }

    /**
     * Define what should do when request is finished.
     */
    @Override
    public void delivered() {
        System.out.println("You cannot finish the request while it is being broadcasted!");
    }
}
