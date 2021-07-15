package com.nch.atmmachine;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu extends Account{
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    /* Validate login information customer number and pin number */
    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(12345, 123);
                data.put(67890, 678);

                System.out.println("Welcome to ATM project!");
                System.out.println("Enter your customer number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter your pin number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid character(s). Only numbers. " + "\n");
                x = 2;
            }
            for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    getAccountType();
                } else {
                    System.out.println("\n" + "Wrong customer number or pin. ");
                }
            }
        }while (x == 1);
    }

    /* Display acc type and menu with selections*/
    public void getAccountType() {
        System.out.println ("Select the account which you want to access: ");
        System.out.println("Type 1 - Checking account");
        System.out.println("Type 2 - Saving account");
        System.out.println("Type 3 - Exit");

        Selection = menuInput.nextInt();

        switch ( Selection ) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank you for using this ATM. Have a good day!");
                break;

            default:
                System.out.println("\n" + "Invalid choice " + "\n");
                getAccountType();
        }
    }

    /* Display checking account menu with selections */
    public void getChecking(){
        System.out.println("Checking account: ");
        System.out.println("Type 1 : View balance");
        System.out.println("Type 2 : Withdraw funds");
        System.out.println("Type 3 : Deposit funds");
        System.out.println("Type 4 : Exit");
        System.out.println("Choice: ");

        Selection = menuInput.nextInt();

        switch (Selection) {
            case 1:
                System.out.println("Checking account balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using this ATM Have a good day!!");
                break;

            default:
                System.out.println("\n" + "Invalid choice" + "\n");
                getChecking();
        }
    }

    /* Display savings account menu with selections */
    public void getSaving() {
        System.out.println("Savings account: ");
        System.out.println("Type 1: View balance ");
        System.out.println("Type 2: withdraw funds ");
        System.out.println("Type 3: Deposit funds ");
        System.out.println("Type 4: Exit ");

        Selection = menuInput.nextInt();

        switch (Selection) {
            case 1:
                System.out.println("Savings account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;

            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using this ATM. Have a good day!! ");
                break;

            default:
                System.out.println("\n" + "Invalid choice" + "\n");
                getSaving();
        }
    }
    int Selection;
}