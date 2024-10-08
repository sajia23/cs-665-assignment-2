package edu.bu.met.cs665;

public class ToDoState implements State {

    DeliveryRequest deliveryRequest;

    public ToDoState(DeliveryRequest deliveryRequest) {
        this.deliveryRequest = deliveryRequest;
    }
    @Override
    public void broadcastRequest() {
        this.deliveryRequest.setState(deliveryRequest.getBroadcastState());
    }

    @Override
    public void onTheWay() {
        System.out.println("You cannot deliver something you haven't even broadcast to drivers!");
    }

    @Override
    public void delivered() {
        System.out.println("You cannot finish delivering that you haven't even broadcast to drivers!");
    }
}
