package com.spock.demo.mocks

import spock.lang.Specification

class PublisherSpec extends Specification {

    def pub = new Publisher()

    def sub1 = Mock(Subscriber)
    def sub2 = Mock(Subscriber)


    void setup() {
        pub.subscribers = [sub1, sub2]
    }

    void "delivers events to all subscribers"() {
        when:
        pub.send("event")

        then:
        1 * sub1.receive(*_)
        1 * sub2.receive("event")
    }





    void "can cope with misbehaving subscribers"() {
        sub1.receive(_) >> { throw new Exception() }

        when:
        pub.send("event1")
        pub.send("event2")

        then:
        1 * sub2.receive("event1")
        1 * sub2.receive("event2")
    }

}
