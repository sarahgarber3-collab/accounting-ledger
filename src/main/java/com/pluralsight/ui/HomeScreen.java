package com.pluralsight.ui;

import com.pluralsight.Main;
import com.pluralsight.model.TransactionApp;
import com.pluralsight.util.AnsiCode;
import com.pluralsight.util.CommonUtils;
import com.pluralsight.util.TransactionWriter;

import java.time.LocalDate;
import java.time.LocalTime;

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
                    double userAmount = Main.scanner.nextDouble();

                    Main.scanner.nextLine();

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
                    double userA = Main.scanner.nextDouble();
                    Main.scanner.nextLine();
                    TransactionApp payment = new TransactionApp(LocalDate.now(), LocalTime.now(), userR, userF, -userA);
                    TransactionWriter.Writer(payment);
                    CommonUtils.formatSpaces();
                    break;

                case "L":
                    new LedgerScreen().display();
                    break;

                case "X": running = false;

                default:
                    AnsiCode.printInvalid();
                    Main.scanner.nextLine();
                    CommonUtils.formatSpaces();

            }
        }
    }
}

