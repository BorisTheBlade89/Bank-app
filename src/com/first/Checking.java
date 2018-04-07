package com.first;

public class Checking extends Account{
    public static String accountType = "Checking";
    Checking(double initialDeposit){
        super();
        this.setBalance(initialDeposit);
        if(initialDeposit > 10000)
            this.setInterest(0.05);
        else   this.setInterest(0.02);
    }
    @Override
    public String toString(){
        return  "Account type: " + accountType + " Account\n" +
                "Account number: " + this.getAccountNumber() + "\n" +
                "Balance: " + this.getBalance() + "\n"+
                "Interest: " +  this.getInterest();
    }
}
