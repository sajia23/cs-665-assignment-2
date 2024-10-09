/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/08/2024
 * File Name: ToDoState.java
 * Description: This class represent current request status.
 */
package edu.bu.met.cs665;

public class ToDoState implements State {

    DeliveryRequest deliveryRequest;

    /**
     * Construction method
     */
    public ToDoState(DeliveryRequest deliveryRequest) {
        this.deliveryRequest = deliveryRequest;
    }

    /**
     * Define what should do when system broadcast the request.
     */
    @Override
    public void broadcastRequest() {
        this.deliveryRequest.setState(deliveryRequest.getBroadcastState());
    }

    /**
     * Define what should do when request is on the way.
     */
    @Override
    public void onTheWay() {
        System.out.println("You cannot deliver something you haven't even broadcast to drivers!");
    }

    /**
     * Define what should do when request is finished.
     */
    @Override
    public void delivered() {
        System.out.println("You cannot finish delivering that you haven't even broadcast to drivers!");
    }
}
