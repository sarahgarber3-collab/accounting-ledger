package com.pluralsight;

import java.util.Scanner;

public class LedgerApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the accounting ledger!");

        homeScreen(scanner);


    }

    public static void homeScreen(Scanner scanner) {


        while (true) {
            System.out.println("Select from the following options: ");
            System.out.println("\tD) Add Deposit");
            System.out.println("\tP) Make Payment(Debit)");
            System.out.println("\tL) Ledger");
            System.out.println("\tX) Exit The Application");
            System.out.print("Enter your selection: ");
            String userOption = scanner.nextLine().toUpperCase();

            switch (userOption) {
                case "D":
                    //addDeposit
                    formatSpaces();
                    break;
                case "P":
                    //makePayment
                    formatSpaces();
                    break;
                case "L":
                    ledgerScreen(scanner);
                    formatSpaces();
                    break;
                case "X":
                    System.out.println("Thanks for using the accounting ledger, Have a nice day!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("incorrect option entered");
                    scanner.nextLine();
                    formatSpaces();

            }


        }

    }

    public static void formatSpaces() {
        System.out.println("\n\n");
    }

    public static void ledgerScreen(Scanner scanner) {


        while (true) {
            System.out.println("Select from the following options: ");
            System.out.println("\tA) All-Display all entries");
            System.out.println("\tD) Deposits- Display only the entries that are deposits into the account");
            System.out.println("\tP) Payments-Display only the negative entries(or payments)");
            System.out.println("\tR) Reports ");
            System.out.print("Enter your selection: ");
            String userOption = scanner.nextLine().toUpperCase();

            switch (userOption) {
                case "A":
                    //DisplayEntries
                    formatSpaces();
                    break;
                case "D":
                    //Deposits
                    formatSpaces();
                    break;
                case "P":
                    //Payments
                    formatSpaces();
                    break;
                case "R":
                    reportScreen(scanner);
                    break;

                default:
                    System.out.println("incorrect option entered");
                    scanner.nextLine();
                    formatSpaces();

            }
        }
    }
    public static void reportScreen(Scanner scanner) {


        while (true) {
            System.out.println("Select from the following options: ");
            System.out.println("\t1) Month to Date");
            System.out.println("\t2) Previous Month");
            System.out.println("\t3) Year to Date");
            System.out.println("\t4) Previous Year");
            System.out.println("\t5) Search by Vendor ");
            System.out.println("\t0) Back - go back to the ledger page.");
            System.out.print("Enter your selection: ");
            int userOption = scanner.nextInt();
            scanner.nextLine();

            switch (userOption) {
                case 1:
                    //Month to Date
                    formatSpaces();
                    break;
                case 2:
                    //Previous month
                    formatSpaces();
                    break;
                case 3:
                    //year to dat
                    formatSpaces();
                    break;
                case 4:
                    //previous year
                    formatSpaces();
                    break;
                case 5:
                    //Search by vendor
                    formatSpaces();
                    break;
                case 0:
                    //go back to ledger page
                    break;
                default:
                    System.out.println("incorrect option entered");
                    scanner.nextLine();
                    formatSpaces();

            }
        }
    }
}