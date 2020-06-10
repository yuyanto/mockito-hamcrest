package com.oreilly;

import java.util.ArrayList;
import java.util.List;

// Adapted from a similar example in the Spock framework
public class Publisher {
    private final List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber sub) {
        if (!subscribers.contains(sub)) {
            subscribers.add(sub);
        }
    }

    public void send(String message) {
        for (Subscriber sub : subscribers) {
            try {
                sub.onNext(message);
            } catch (Exception ignored) {
                // evil, but what can you do?
            }
        }
    }
}
