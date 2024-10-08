package edu.bu.met.cs665;

public class BroadcastState implements State {

    DeliveryRequest deliveryRequest;

    public BroadcastState(DeliveryRequest deliveryRequest) {
        this.deliveryRequest = deliveryRequest;
    }
    @Override
    public void broadcastRequest() {
        System.out.println("You cannot broadcast a request  the request while it is being broadcasted!");
    }

    @Override
    public void onTheWay() {
        this.deliveryRequest.setState(deliveryRequest.getDoingState());
    }

    @Override
    public void delivered() {
        System.out.println("You cannot finish the request while it is being broadcasted!");
    }
}
