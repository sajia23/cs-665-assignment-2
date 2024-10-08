package edu.bu.met.cs665;

import javax.swing.event.DocumentEvent;
import java.util.List;

/**
 * This is Subscriber interface for Observer Pattern.
 */
public interface SubscriberBase {

    void updateSelf(DeliveryRequest deliveryRequest);

}
