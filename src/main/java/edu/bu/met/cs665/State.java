package edu.bu.met.cs665;

public interface State {
    void broadcastRequest();

    void onTheWay();

    void delivered();
}
