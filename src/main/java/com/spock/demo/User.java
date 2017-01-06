package com.spock.demo;

public class User {

    public String firstName;
    public String lastName;
    public String gender;
    public Integer age;
    private Account account;
    private AccountStatus accountStatus;

    public User(String firstName, String lastName, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        accountStatus = AccountStatus.APPLICATION_RECEIVED;
    }


    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
        this.setAccountStatus(AccountStatus.APPLICATION_ACCEPTED);
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User() {
        accountStatus = AccountStatus.APPLICATION_RECEIVED;
    }


    public String getDisplayName() {
        String title = "";
        if (age > 15) {
            if (gender.equals("Male")) {
                title = "Mr ";
            } else {
                title = "Miss ";
            }
        } else {
            if (gender.equals("Male")) {
                title = "Master ";
            }
        }
        String fullName = title + firstName + " " + lastName;
        return fullName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }



}
