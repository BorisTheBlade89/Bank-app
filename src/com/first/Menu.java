package com.first;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner keyboard = new Scanner(System.in);
    Bank bank  = new Bank();
    boolean exit;

    public void runMenu(){
        printHeader();
        while(!exit){
            printMenu();
            int choice = getInput();
            performAction(choice);
        }
    }
    private void printHeader() {
        System.out.println("+----------------------------------+");
        System.out.println("      Welcome to Boris' bank        ");
        System.out.println("        Enjoy your stay!            ");
        System.out.println("+----------------------------------+");
    }
    private void printMenu(){
        System.out.println("Please make a seleciton: ");
        System.out.println("1) Create new account");
        System.out.println("2) Make a deposit");
        System.out.println("3) Make a withdrawal");
        System.out.println("4) Account balance");
        System.out.println("5) exit");
    }
    private int getInput(){
        int choice = 0;
        do {
            if (choice < 0 || choice > 5)
                System.out.println("Outside of range.");
            try{
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only.");
            }
        }while(choice < 0 || choice > 4);
        return choice;
    }
    private void performAction(int choice){
        switch (choice){
            case 0:
                System.out.println("Thank you for using our services.");
                System.exit(0);
                break;
            case 1:
                createAccount();
                break;
            case 2:
                makeDeposit();
                 break;
            case 3:
                withdraw();
                break;
            case 4:
                listBalances();
                break;

            default:
                    System.out.println("Unknown error has occured");
        }
    }


    private void createAccount() {
        String firstName, lastName, ssn;
        String accountType = "";
        Double initialDeposit = null;
        boolean valid = false;
        while(!valid){
            System.out.println("Please enter the account type: checking / savings");
            accountType = keyboard.nextLine();
            if(accountType.equalsIgnoreCase("checking") || accountType.equalsIgnoreCase("savings"))
                valid = true;
            else System.out.println("Please only enter checking or savings.");
        }
        System.out.println("please enter your first name: ");
        firstName = keyboard.nextLine();
        System.out.println("Please enter your last name: ");
        lastName = keyboard.nextLine();
        System.out.println("Please enter your ssn");
        ssn = keyboard.nextLine();
        valid = false;
        while(!valid) {
            System.out.println("Please enter your initial deposit: ");
            try {
                initialDeposit = Double.parseDouble(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error. It must be a number.");
            }
            if (accountType.equalsIgnoreCase("checking"))
                if (initialDeposit < 100)
                    System.out.println("Minimum for checking account is 100$");
                    else {
                         valid = true;
                     }
                else if (accountType.equalsIgnoreCase("savings"))
                    if (initialDeposit < 50)
                          System.out.println("Minimum for savings account is 50$");
                     else {
                        valid = true;
                    }
        }
        Account account = null;
        if (accountType.equalsIgnoreCase("checking"))
            account = new Checking(initialDeposit);
        else if (accountType.equalsIgnoreCase("savings")) account = new Savings(initialDeposit);
        Customer customer = new Customer(firstName, lastName, ssn, account);
        bank.addCustomer(customer);
    }
    private void makeDeposit() {
        int account = selectAccount();
        if (account >= 0) {
            System.out.println("How much would you like to deposit?");
            double amount = 0;
            try {
                amount = Double.parseDouble(keyboard.nextLine());
            } catch (NumberFormatException e) {
                amount = 0;
            }
            bank.getCustomer(account).getAccount().deposit(amount);
        }
    }

    private int selectAccount() {
        ArrayList<Customer> customers = bank.getCustomers();
        if (customers.size() <= 0) {
            System.out.println("No customers at your bank.");
            return -1;
        }
        System.out.println("Select an account: ");
        for (int i = 0; i< customers.size(); i++){
            System.out.println(i+1 + ")" + customers.get(i).basicInfo());
        }
        int account = 0;
        System.out.println("Please enter your selection: ");
        try{
            account = Integer.parseInt(keyboard.nextLine());
        }
        catch (NumberFormatException e){
            account = -1;
        }
        if (account < 0 || account > customers.size())
            System.out.println("Invalid account selected.");
            account = -1;
        return 0;
    }

    private void withdraw() {
        int account = selectAccount();
        if (account >= 0) {
            System.out.println("How much would you like to witdraw?");
            double amount = 0;
            try {
                amount = Double.parseDouble(keyboard.nextLine());
            } catch (NumberFormatException e) {
                amount = 0;
            }
            bank.getCustomer(account).getAccount().withdraw(amount);
        }
    }

    private void listBalances() {
        int account = selectAccount();
        if(account >= 0)
            System.out.println(bank.getCustomer(account).getAccount());
    }
}

