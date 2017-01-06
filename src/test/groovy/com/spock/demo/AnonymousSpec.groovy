package com.spock.demo

import spock.lang.FailsWith
import spock.lang.IgnoreIf
import spock.lang.IgnoreRest
import spock.lang.Requires
import spock.lang.Specification
import spock.lang.Unroll

class AnonymousSpec extends Specification {


    void setup() {}

    void cleanup(){}

    void cleanupSepc(){}

    void setupSpec(){}


    void "Canary Spec"(){
        expect:
        true
    }





    void "Understand blocks"() {
        given:
        String toBeSearched = "New York";

        and:
        List<String> allCities = ["Delh", "Bangalore", "London", "New York"]

        when:
        Boolean isPresent = allCities.any { it == toBeSearched }

        then:
        isPresent == true
    }






    void "Maximum of two can be found"() {
        when:
        Integer maxOfTwo = Math.max(3, 5)

        then:
        maxOfTwo == 4
    }


    void "Compare two strings "() {
        expect:
        "flower" == "flowers"
    }





    void "An exception is thrown when we pop from an empty stack"() {
        given:
        Stack stack = new Stack()

        when:
        stack.pop()

        then:
        def e =thrown(EmptyStackException)
        e.message == "Some message"
    }

    void "HashMap accepts null key"() {
        setup:
        def map = new HashMap()

        when:
        map.put(null, "elem")

        then:
        notThrown(NullPointerException)
    }




  //DATA Driven testing goes here

    void "computing the maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        a << [5, 3]
        b << [1, 9]
        c << [5, 9]
    }

    @Unroll
    void "computing the maximum of two numbers - 2"(){
        expect:
        Math.max(first, second) == expected

        where:
        first | second || expected
        5     | 1      || 5
        9     | 0      || 9
        3     | -1     || 3
        3     | -1     || 0
    }

    @Unroll("computing the maximum of #first and #second is #expected")
    void "something new the maximum of #first and #second is #expected"() {
        expect:
        Math.max(first, second) == expected

        where:
        first | second || expected
        5     | 1      || 5
        9     | 0      || 9
        3     | -1     || 3
//        3     | -1     || 0
    }

    void "Account object is created with correct initial values"() {
        when:
        Account account = new Account()

        then:
        with(account) {
            balance == BigDecimal.ZERO
            accountNumber == "dummy"
        }
    }

    void "comparing both old an new list"() {
        given:
        List l = [1, 2, 3]

        when:
        l << 4 << 5

        then:
        l.size() == 5
        old(l.size()) == 3
    }


//    @IgnoreIf({jvm.java7})
//    @Requires({ os.linux })
    @Requires({ jvm.java8 })
    void " java 8 feature should be run only in java 8"() {
        given:
        List<Integer> numbers = [1,2,3,4]

        expect:
        numbers.stream().any{it>1}
    }

    @Unroll
    def "maximum of two numbers"() {
        setup:

        def emailService = Mock(EmailService)
        EmailService emailService2 = Mock()

        expect:
        true

        where:
        a | b | c
        1 | 3 | 3
        7 | 4 | 7
        0 | 0 | 0
    }



}
