package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LedgerApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\uD83D\uDCB0Welcome to the accounting ledger!\uD83D\uDCB0");



        homeScreen(scanner);


    }

    public static void homeScreen(Scanner scanner) {


        while (true) {
            System.out.println("Select from the following options:");
            System.out.println("\tD) Add Deposit");
            System.out.println("\tP) Make A Payment(Debit)");
            System.out.println("\tL) Ledger");
            System.out.println("\tX) Exit The Application");
            System.out.print("Enter your selection: ");
            String userOption = scanner.nextLine().toUpperCase();

            switch (userOption) {
                case "D":
                    System.out.print("Give a brief description of what the deposit is for?: ");
                    String userReason = scanner.nextLine();
                    System.out.print("Who/what is it from(vendor)?: ");
                    String userFrom = scanner.nextLine();
                    System.out.print("How much is the amount?: ");
                    double userAmount = scanner.nextDouble();
                    scanner.nextLine();
                    TransactionApp deposit = new TransactionApp(LocalDate.now(), LocalTime.now(),userReason,userFrom,userAmount);
                    saveTransaction(deposit);
                    formatSpaces();
                    break;
                case "P":
                    System.out.print("Give a brief description of what the Payment is for?: ");
                    String userR = scanner.nextLine();
                    System.out.print("Who is it for(vendor)?: ");
                    String userF = scanner.nextLine();
                    System.out.print("How much was the amount?: ");
                    double userA = scanner.nextDouble();
                    scanner.nextLine();
                    TransactionApp payment = new TransactionApp(LocalDate.now(), LocalTime.now(),userR,userF,-userA);
                    saveTransaction(payment);
                    formatSpaces();
                    break;
                case "L":
                    ledgerScreen(scanner);
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
        ArrayList<TransactionApp> transaction = loadTransaction();


        boolean run = true;
        while (run) {
            System.out.println("Select from the following options: ");
            System.out.println("\tA) All-Display all entries");
            System.out.println("\tD) Deposits- Display only the entries that are deposits into the account.");
            System.out.println("\tP) Payments-Display only the negative entries(or payments). ");
            System.out.println("\tR) Reports. ");
            System.out.println("\tH) Home - go back to the home page.");
            System.out.print("Enter your selection: ");
            String userOption = scanner.nextLine().toUpperCase();

            switch (userOption) {
                case "A":
                    for (TransactionApp t: transaction ) {
                        t.printTransaction();
                    }
                    formatSpaces();
                    break;
                case "D":
                    for (TransactionApp t: transaction ) {
                        if(t.getAmount() > 0){
                            t.printTransaction();
                        }
                    }
                    formatSpaces();
                    break;
                case "P":
                    for (TransactionApp t: transaction ) {
                        if (t.getAmount() < 0) {
                            t.printTransaction();
                        }
                    }
                    formatSpaces();
                    break;
                case "R":
                    reportScreen(scanner, transaction);
                    break;
                case "H":
                    run = false;
                    break;

                default:
                    System.out.println("incorrect option entered");
                    scanner.nextLine();
                    formatSpaces();

            }
        }
    }
    public static void reportScreen(Scanner scanner,ArrayList<TransactionApp> transaction ) {


        boolean run = true;
        while (run) {
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
                    for (TransactionApp t: transaction ) {
                        if (t.getDate().getMonth()==LocalDate.now().getMonth() && t.getDate().getYear()==LocalDate.now().getYear()) {
                            t.printTransaction();
                        }
                    }
                    formatSpaces();
                    break;
                case 2:
                    for (TransactionApp t: transaction ) {
                        if (t.getDate().getMonth()==LocalDate.now().minusMonths(1).getMonth() && t.getDate().getYear()==LocalDate.now().minusMonths(1).getYear()) {
                            t.printTransaction();
                        }
                    }
                    formatSpaces();
                    break;
                case 3:
                    for (TransactionApp t: transaction ) {
                        if (t.getDate().getYear()==LocalDate.now().getYear()) {
                            t.printTransaction();
                        }
                    }
                    formatSpaces();
                    break;
                case 4:
                    for (TransactionApp t: transaction ) {
                        if (t.getDate().getYear()==LocalDate.now().minusYears(1).getYear()) {
                            t.printTransaction();
                        }
                    }
                    formatSpaces();
                    break;
                case 5:
                    System.out.print("What vendor are you looking for today?: ");
                    String vendor = scanner.nextLine();
                    for (TransactionApp t: transaction ) {
                        if (t.getVendor().equalsIgnoreCase(vendor)) {
                            t.printTransaction();
                        }
                    }
                    formatSpaces();
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println("incorrect option entered");
                    scanner.nextLine();
                    formatSpaces();

            }
        }
    }
    public static ArrayList<TransactionApp> loadTransaction () {
        ArrayList<TransactionApp> transaction = new ArrayList<>();
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/transactions.csv"));
            String transactionItem;
            bufReader.readLine();
            while ((transactionItem = bufReader.readLine()) != null) {
                String[] splitTransactionItem = transactionItem.split("\\|");
                LocalDate date = LocalDate.parse(splitTransactionItem[0]);
                LocalTime time = LocalTime.parse(splitTransactionItem[1]);
                String description = splitTransactionItem[2];
                String vendor = splitTransactionItem[3];
                double amount = Double.parseDouble(splitTransactionItem[4]);

                TransactionApp transactions = new TransactionApp(date,time,description,vendor,amount);
                transaction.add(transactions);

            }
            Collections.reverse(transaction);
            bufReader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transaction;
    }
    public static void saveTransaction(TransactionApp transaction) {
        try {
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv", true));
            bufWriter.newLine();
            bufWriter.write(transaction.formatCSV());
            bufWriter.close();

            } catch (IOException e) {
                e.printStackTrace();

        }
    }

}