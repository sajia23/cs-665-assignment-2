package edu.bu.met.cs665;

public class DoneState implements State {

    DeliveryRequest deliveryRequest;

    public DoneState(DeliveryRequest deliveryRequest) {
        this.deliveryRequest = deliveryRequest;
    }
    @Override
    public void broadcastRequest() {
        System.out.println("You cannot broadcast the request while it is done!");
    }

    @Override
    public void onTheWay() {
        System.out.println("You cannot broadcast the request while it is done!");
    }

    @Override
    public void delivered() {
        System.out.println("You cannot broadcast the request while it is done!");
    }
}
