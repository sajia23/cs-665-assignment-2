/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/08/2024
 * File Name: DeliveryRequest.java
 * Description: This class defines a delivery request.
 */
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

    /**
     * Construction method
     */
    public DeliveryRequest() {
        this.toDoState = new ToDoState(this);
        this.doingState = new DoingState(this);
        this.doneState = new DoneState(this);
        this.broadcastState = new BroadcastState(this);
        this.state = toDoState;
        this.deliveryLogs = new ArrayList<>();
    }

    /**
     * Construction method
     */
    public String getDriverRegisterNumber() {
        return driverRegisterNumber;
    }

    /**
     * Set the driver's registration number to the current request.
     * @Param driverRegisterNumber
     */
    public void setDriverRegisterNumber(String driverRegisterNumber) {
        this.driverRegisterNumber = driverRegisterNumber;
    }

    /**
     * Get delivery logs
     */
    public List<String> getDeliveryLogs() {
        return deliveryLogs;
    }

    /**
     * Set customer name to the delivery request
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Execute broadcast action over the request
     */
    public void broadcastRequest() {
        state.broadcastRequest();
    }

    /**
     * Execute onTheWay action over the request
     */
    public void onTheWay() {
        state.onTheWay();
    }

    /**
     * Execute finish action over the request
     */
    public void delivered() {
        state.delivered();
    }

    /**
     * Get doing state
     */
    public State getDoingState() {
        return this.doingState;
    }

    /**
     * Get done state
     */
    public State getDoneState() {
        return this.doneState;
    }

    /**
     * Get broadcast state
     */
    public State getBroadcastState() {
        return this.broadcastState;
    }

    /**
     * Set the state
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Set customer address to the delivery request
     */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     * Set customer phone to the delivery request
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    /**
     * Set items to the delivery request
     */
    public void setItems(String items) {
        this.items = items;
    }

    /**
     * Set expected driver type to the delivery request
     */
    public void setRequestDriverType(DriverType requestDriverType) {
        this.requestDriverType = requestDriverType;
    }

    /**
     * Get driver type of current request
     */
    public DriverType getRequestDriverType() {
        return requestDriverType;
    }
}
