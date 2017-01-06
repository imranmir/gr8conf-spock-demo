package com.spock.demo;


import java.math.BigDecimal;

public class Account {
    String accountNumber;
    BigDecimal balance;
    String contactEmail;
    Integer pointsEarned;

    public BigDecimal getBalance() {
        return this.balance;
    }

    public Account(){
        this.accountNumber = getNewAccountNumber();
        this.balance = BigDecimal.ZERO;
    }

    String getNewAccountNumber(){
        return "dummy";
    }

    public Account(String accountNumber, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void debit(BigDecimal amount) throws InsufficientFundsException {
        if (this.balance.compareTo(amount) > 0 ) {
            this.balance = this.balance.subtract(amount);
        } else {
            throw new InsufficientFundsException("Insufficent balance for the transaction");
        }
    }

    void credit(BigDecimal amount) throws IllegalOperationException{
        if(amount.compareTo(BigDecimal.ZERO) == 1) {
            this.balance.add(amount);
        }else{
            throw new IllegalOperationException("Amout cannot be less than zero");
        }
    }
}
