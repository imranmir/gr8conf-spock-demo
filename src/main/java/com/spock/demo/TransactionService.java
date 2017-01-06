package com.spock.demo;


import java.math.BigDecimal;

public class TransactionService {
    EmailService emailService = new EmailService();
    LoggingService loggingService = new LoggingService();

    PointsAnalyzerService analyzerService = new PointsAnalyzerService();

    public void transact(Account source, Account destination, BigDecimal amount) {
        try {
            source.debit(amount);
            destination.credit(amount);
            Transaction transaction = new Transaction(source, destination);

            loggingService.log(transaction.id);

            emailService.sendMail(source.contactEmail, amount, "debit");
            emailService.sendMail(destination.contactEmail, amount, "credit");

        } catch (InsufficientFundsException e) {
        } catch (IllegalOperationException e) {
        }
    }




    public BigDecimal getDiscountWorth(Account account) {
        PointsBand band = analyzerService.analyze(account);

        BigDecimal discount = new BigDecimal(0.0);

        if (band == PointsBand.PLATINUM) {
            discount = new BigDecimal(100.0);
        }
        else if (band == PointsBand.SILVER) {
            discount = new BigDecimal(200.0);
        }
        else if (band == PointsBand.GOLD) {
            discount = new BigDecimal(300.0);
        }
        return discount;
    }

    public BigDecimal calculatePointsForTheTransaction(){
          return new BigDecimal(300.0);
    }

}
