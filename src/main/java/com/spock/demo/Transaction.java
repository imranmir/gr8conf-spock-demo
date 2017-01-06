package com.spock.demo;

import java.util.UUID;

public class Transaction {
    Account source;
    Account destination;
    String id;

    Transaction(Account source, Account destination){
        this.source = source;
        this.destination = destination;
        this.id = UUID.randomUUID().toString();
    }
}
