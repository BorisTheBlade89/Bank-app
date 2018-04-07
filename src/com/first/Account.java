package com.first;


public class Account {
    private Double balance;
    private Double interest;
    private int accountNumber;
    private static int numberOfAccounts = 1000000;

    Account(){
        accountNumber = numberOfAccounts++;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getInterest() {
        return interest*100;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void withdraw(double amount){
        if(amount + 5 > balance){
            System.out.println("Insufficient funds.");
            return;
        }

        balance -= amount + 5;
        System.out.println("You have withdrawn " + amount+ " and inccured a fee of $5");
        System.out.println("You now have a balance of $" + balance);
    }
    public void deposit(double amount){
        if (amount <= 0 ) {
            System.out.println("Can't deposit negative money.");
            return;
        }
        amount = amount + amount*interest;
        balance += amount;
        System.out.println("You have deposited $"+amount+" with an interest rate of $"+(interest*100)+" %");
        System.out.println("You now have a balance of $" + balance);
    }

}
