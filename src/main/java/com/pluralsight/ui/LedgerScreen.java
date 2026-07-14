package com.pluralsight.ui;

import com.pluralsight.Main;
import com.pluralsight.model.TransactionApp;
import com.pluralsight.model.Transaction;
import com.pluralsight.util.AnsiCode;
import com.pluralsight.util.CommonUtils;
import com.pluralsight.service.LedgerChoice;

import java.util.ArrayList;

public class LedgerScreen {

    public void display() {
        ArrayList<TransactionApp> transaction = Transaction.loadTransaction();

        boolean running = true;

        while (running) {

            AnsiCode.printLedgerScreenMenu();
            String userOption = Main.scanner.nextLine().toUpperCase();

            switch (userOption) {
                case "A" -> LedgerChoice.ledgerChoice(transaction, "all");
                case "D" -> LedgerChoice.ledgerChoice(transaction, "deposits");
                case "P" -> LedgerChoice.ledgerChoice(transaction, "payments");
                case "R" -> ReportScreen.display(transaction);
                case "H" -> running = false;

                default -> {
                    AnsiCode.exitLedgerScreen();
                    Main.scanner.nextLine();
                    CommonUtils.formatSpaces();
                }

            }
        }
    }

}
