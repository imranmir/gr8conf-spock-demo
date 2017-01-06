package com.spock.demo

import spock.lang.Specification

class AccountSpec extends Specification {


    void "Canary Test"() {
        expect:
        true
    }


    void "When an amount is withdrawn it should be reflected in the balance"() {
        given:
        Account account = new Account("10001", 10000.0);

        when:
        account.debit(500.0);

        then:
        account.balance == 9500.0
    }


    void "An exception is thrown if we try to debit an account with insufficient"() {
        given:
        Account account = new Account("1001", 100.0)

        when:
        account.debit(200.0)

        then:

        def e = thrown(InsufficientFundsException)
        e.msg == "Insufficent balance for the transaction"
    }





}
