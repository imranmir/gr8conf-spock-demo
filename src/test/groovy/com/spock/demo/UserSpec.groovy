package com.spock.demo

import com.spock.demo.extensions.SayOnFail
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Unroll

class UserSpec extends Specification {



    User user

    void setup() {
        user = new User(firstName: 'Glen', lastName: 'Maxwell', gender: "Male")
    }

    void "Canary test"() {
        expect:
        true
    }

    void "A user account should be enabled once his account balance is greater than zero"() {
        given: "An account"
        Account account = new Account()

        expect: "Verifying initial account status is  APPLICATION_RECEIVED"
        user.accountStatus == AccountStatus.APPLICATION_RECEIVED

        when: "An account is set"
        user.account = account

        then: "The account status changes to APPLICATION_ACCEPTED"
        user.accountStatus == AccountStatus.APPLICATION_ACCEPTED
    }

    void "Display name is the concatination of first name and the last name"() {
        expect:
        user.displayName == "Mr Glen Maxwell"
    }




    //DATA DRIVE TESTING
    @Unroll("For gender: #gender age: #age the expeted displayname is #expected")
    void "Display name is created for a user"() {
        given:
        User user = new User(firstName: firstName, lastName: lastName, age: age, gender: gender)

        expect:
        user.displayName == expected

        where:
        firstName | lastName | age | gender   || expected
        "First"   | "Last"   | 16  | "Male"   || "Mr First Last"
        "First"   | "Last"   | 10  | "Male"   || "Master First Last"
        "First"   | "Last"   | 16  | "Female" || "Mis First Last"
        "First"   | "Last"   | 13  | "Female" || "First Last"
    }

}
