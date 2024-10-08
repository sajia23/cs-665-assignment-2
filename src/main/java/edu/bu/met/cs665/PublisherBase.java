package edu.bu.met.cs665;

/**
 * This is Publisher interface for Observer Pattern.
 */
public interface PublisherBase {
    void subscribe(SubscriberBase o);

    void unsubscribe(String name);

    void notifySubscribers(DeliveryRequest deliveryRequest);
}
