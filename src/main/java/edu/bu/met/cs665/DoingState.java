package edu.bu.met.cs665;

public class DoingState implements State {

    DeliveryRequest deliveryRequest;

    public DoingState(DeliveryRequest deliveryRequest) {
        this.deliveryRequest = deliveryRequest;
    }

    @Override
    public void broadcastRequest() {
        System.out.println("You cannot broadcast the request while it is on the way!");
    }

    @Override
    public void onTheWay() {
        System.out.println("You cannot deliver while it is on the way!");
    }

    @Override
    public void delivered() {
        this.deliveryRequest.setState(deliveryRequest.getDoneState());
    }
}
