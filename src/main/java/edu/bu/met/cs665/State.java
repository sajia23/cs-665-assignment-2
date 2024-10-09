/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/08/2024
 * File Name: State.java
 * Description: This interface defines methods for state
 */
package edu.bu.met.cs665;

public interface State {
    void broadcastRequest();

    void onTheWay();

    void delivered();
}
