package com.spock.demo.mocks;

import java.util.List;

public class Publisher {

    public List<Subscriber> subscribers;

    void send(String event) {
        for (Subscriber subscriber : subscribers) {
            try {
                subscriber.receive(event);
            } catch (Exception e) {
            }
        }
    }
}


