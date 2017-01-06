package com.spock.demo

import com.spock.demo.extensions.SayOnFail
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll



class TransactionServiceSpec extends Specification {



    void "An email is sent to both the source and destionation account emails after a transaction"(){
        given: "A source account"
        Account source = new Account(balance: 1000, contactEmail: "user1@spock.com")

        and: "A destination account"
        Account destination = new Account(balance: 200, contactEmail: "user2@spock.com")

        and:
        @Subject
        TransactionService service = new TransactionService()

        and: "Creating and setting EmailService Mock"
        def emailService = Mock(EmailService)
        service.emailService = emailService

        when:
        service.transact(source, destination, 300.0)

        then:
        1 * emailService.sendMail(source.contactEmail, 300.0, "debit")
        1 * emailService.sendMail(destination.contactEmail, 300.0, "credit")
//        2 * emailService.sendMail(_ as String, _ as BigDecimal, _ as String)

    }








    void "Transaction id is logged before sending an email during a transaction"(){
        given: "A source account"
        Account source = new Account(balance: 1000.0, contactEmail: "user1@spock.com")

        and: "A destination account"
        Account destination = new Account(balance: 200.0, contactEmail: "user2@spock.com")

        and:
        @Subject
        TransactionService service = new TransactionService()

        and: "Initializing and setting EmailService mock"
        def emailService = Mock(EmailService)
        service.emailService = emailService

        and: "Initializing and setting LoggingService mock"
        def loggingService = Mock(LoggingService)
        service.loggingService = loggingService

        when:
        service.transact(source, destination, 300.0)

//        then: "Transaction id is logged first"
//        1 * loggingService.log(_ as String)

        then:
        1 * loggingService.log(_ as String)
        then: "Emails are sent"
        1 * emailService.sendMail(source.contactEmail, 300.0, "debit")

        then:
        1 * emailService.sendMail(destination.contactEmail, 300.0, "credit")


    }

    void "State the feature to be tested"(){
        //Test Code
    }









    @SayOnFail
    void "Disount is calculated for an account"() {
        given: "A source account"
        Account account = new Account(balance: 1000.0)

        and:
        @Subject
        TransactionService service = new TransactionService()

        and:

        PointsAnalyzerService analyzerService = Mock(PointsAnalyzerService)
        analyzerService.analyze(account) >> PointsBand.GOLD

        service.analyzerService = analyzerService

        when:
        BigDecimal disoucount = service.getDiscountWorth(account)

        then:
        2 * analyzerService.analyze(account) >> PointsBand.GOLD
        disoucount == new BigDecimal(300.0)
    }

    void "Disount is calculated for an account -Stub example"() {
        given: "A source account"

        Account account = new Account(balance: 1000.0)

        and:
        @Subject
        TransactionService service = new TransactionService()

        and:
        PointsAnalyzerService analyzerService = Stub(PointsAnalyzerService)
        service.analyzerService = analyzerService

        when:
        BigDecimal disoucount = service.getDiscountWorth(account)

        then:
        analyzerService.analyze(account) >> PointsBand.GOLD
        disoucount == new BigDecimal(300.0)
    }

}
