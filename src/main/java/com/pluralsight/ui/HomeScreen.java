package com.pluralsight.ui;

import com.pluralsight.Main;
import com.pluralsight.model.InvalidTransactionException;
import com.pluralsight.model.TransactionApp;
import com.pluralsight.model.TransactionValidator;
import com.pluralsight.util.AnsiCode;
import com.pluralsight.util.CommonUtils;
import com.pluralsight.util.TransactionWriter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;

public class HomeScreen {

    public void display() {

        boolean running = true;

        while (running) {

            AnsiCode.displayStartScreen();

            String userOption = Main.scanner.nextLine().toUpperCase();

            switch (userOption) {
                case "D":
                    System.out.print("Give a brief description of what the deposit is for?: ");
                    String userReason = Main.scanner.nextLine();
                    System.out.print("Who/what is it from(vendor)?: ");
                    String userFrom = Main.scanner.nextLine();
                    System.out.print("How much is the amount?: ");
                    double userAmount;
                    try {
                        userAmount = Main.scanner.nextDouble();
                        Main.scanner.nextLine();
                        TransactionValidator.validate(userReason, userFrom, userAmount);
                    }catch (InputMismatchException e){
                        System.out.println("That is not a vaild number. Returning to the home screen.");
                        Main.scanner.nextLine();
                        CommonUtils.formatSpaces();
                        break;
                    }catch (InvalidTransactionException e){
                        System.out.println("Unable to save transaction: " + e.getMessage());
                        CommonUtils.formatSpaces();
                        break;
                    }

                    TransactionApp deposit = new TransactionApp(LocalDate.now(), LocalTime.now(), userReason, userFrom, userAmount);
                    TransactionWriter.Writer(deposit);

                    CommonUtils.formatSpaces();
                    break;

                case "P":
                    System.out.print("Give a brief description of what the Payment is for?: ");
                    String userR = Main.scanner.nextLine();
                    System.out.print("Who is it for(vendor)?: ");
                    String userF = Main.scanner.nextLine();
                    System.out.print("How much was the amount?: ");
                    double userA;
                    try {
                        userA = Main.scanner.nextDouble();
                        Main.scanner.nextLine();
                        TransactionValidator.validate(userR, userF, userA);
                    }catch (InputMismatchException e){
                        System.out.println("That is not a valid number. Returning back to home screen.");
                        Main.scanner.nextLine();
                        CommonUtils.formatSpaces();
                        break;
                    }catch (InvalidTransactionException e){
                        System.out.println("Unable to save transaction: " + e.getMessage());
                        CommonUtils.formatSpaces();
                        break;
                    }
                    TransactionApp payment = new TransactionApp(LocalDate.now(), LocalTime.now(), userR, userF, -userA);
                    TransactionWriter.Writer(payment);
                    CommonUtils.formatSpaces();
                    break;

                case "L":
                    new LedgerScreen().display();
                    break;

                case "X": running = false;
                AnsiCode.exitHome();
                System.exit(0);

                default:
                    AnsiCode.printInvalid();
                    Main.scanner.nextLine();
                    CommonUtils.formatSpaces();

            }
        }
    }
}

