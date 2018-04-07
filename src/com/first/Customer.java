package com.first;

public class Customer {
    private String firstName, lastName, ssn;
    private Account account;
    public Customer(String firstName, String lastName, String ssn, Account account) {
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }
    public String toString(){
        return "Customer info: " + firstName + "\n " + lastName + "\n " + ssn +"\n"+ account.getAccountNumber();
    }
    public String basicInfo(){
        return "Customer info: " + firstName + " " + lastName + " " + ssn + account.getAccountNumber();
    }
    Account getAccount(){
        return account;
    }
}
