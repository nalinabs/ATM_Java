package com.nch.atmmachine;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    /* set the customer number */
    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    /* get the customer number */
    public int getCustomerNumber() {
        return customerNumber;
    }

    /* set the pin number */
    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    /* get the pin number */
    public int getPinNumber() {
        return pinNumber;
    }

    /* get checking account balance */
    public double getCheckingBalance() {
        return checkingBalance;
    }

    /* get savings account balance */
    public double getSavingBalance() {
        return savingBalance;
    }

    /* Calculate checking account withdrawal */
    public double calcCheckingWithdraw(double amount) {
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    /* Calculate  Savings account withdrawal */
    public double calcSavingWithdraw(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    /* Calculate checking balance deposit */
    public double calcCheckingDeposit(double amount) {
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    /* Calculate saving account deposit */
    public double calcSavingDeposit(double amount) {
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    /* customer checking account withdraw input */
    public void getCheckingWithdrawInput() {
        System.out.println("Checking account balance: " + moneyFormat.format(checkingBalance));
        System.out.println(" Amount you want to withdraw from checking balance: ");
        double amount = input.nextDouble();

        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("New  checking account balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance can not be negative." + "\n");
        }
    }

    /* Customer saving account withdraw input */
    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to withdraw from Saving account: ");
        double amount = input.nextDouble();

        if ((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("New saving account balance: " + savingBalance + "\n");
        } else {
            System.out.println(" Balance can not be negative." + "\n");
        }
    }

    /*Customer checking account deposit input */
    public void getCheckingDepositInput() {
        System.out.println("Checking account balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to deposit from checking account: ");
        double amount = input.nextDouble();

        if ((checkingBalance + amount) >= 0) {
            calcCheckingDeposit(amount);
            System.out.println("New checking account balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance can not be negative." + "\n");
        }
    }

    /* customer saving account deposit input */
    public void getSavingDepositInput() {
        System.out.println("Saving account balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to deposit from savings account: " + "\n");
        double amount = input.nextDouble();

        if ((savingBalance = amount) >= 0) {
            calcSavingDeposit(amount);
            System.out.println("New savings account balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Balance can not be negative");
        }
    }

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;
}
