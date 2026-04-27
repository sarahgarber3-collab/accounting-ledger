package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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
                    System.out.print("What is the deposit for?: ");
                    String userReason = scanner.nextLine();
                    System.out.print("Who is it from?: ");
                    String userFrom = scanner.nextLine();
                    System.out.println("How much is it?: ");
                    Double userAmount = scanner.nextDouble();
                    TransactionApp deposit = new TransactionApp(LocalDate.now(), LocalTime.now(),userReason,userFrom,userAmount);
                    saveTransaction(deposit);
                    formatSpaces();
                    break;
                case "P":
                    System.out.print("What is the Payment for?: ");
                    String userR = scanner.nextLine();
                    System.out.print("Who is it for?: ");
                    String userF = scanner.nextLine();
                    System.out.println("How much was it?: ");
                    Double userA = scanner.nextDouble();
                    TransactionApp payment = new TransactionApp(LocalDate.now(), LocalTime.now(),userR,userF,-userA);
                    saveTransaction(payment);
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
    public static void reportScreen(Scanner scanner) {


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