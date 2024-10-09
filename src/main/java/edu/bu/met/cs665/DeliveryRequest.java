package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;

public class DeliveryRequest {
    State toDoState;
    State doingState;
    State doneState;
    State broadcastState;
    State state;
    String customerName;
    String customerAddress;
    String customerPhone;
    String driverRegisterNumber;
    String items;
    DriverType requestDriverType;

    List<String> deliveryLogs;

    public String getDriverRegisterNumber() {
        return driverRegisterNumber;
    }

    public void setDriverRegisterNumber(String driverRegisterNumber) {
        this.driverRegisterNumber = driverRegisterNumber;
    }

    public DeliveryRequest() {
        this.toDoState = new ToDoState(this);
        this.doingState = new DoingState(this);
        this.doneState = new DoneState(this);
        this.broadcastState = new BroadcastState(this);
        this.state = toDoState;
        this.deliveryLogs = new ArrayList<>();
    }

    public List<String> getDeliveryLogs() {
        return deliveryLogs;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void broadcastRequest() {
        state.broadcastRequest();
    }

    public void onTheWay() {
        state.onTheWay();
    }

    public void delivered() {
        state.delivered();
    }

    public State getDoingState() {
        return this.doingState;
    }

    public State getDoneState() {
        return this.doneState;
    }

    public State getBroadcastState() {
        return this.broadcastState;
    }

    public State getTodoState() {
        return this.toDoState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public void setRequestDriverType(DriverType requestDriverType) {
        this.requestDriverType = requestDriverType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getItems() {
        return items;
    }

    public DriverType getRequestDriverType() {
        return requestDriverType;
    }
}
