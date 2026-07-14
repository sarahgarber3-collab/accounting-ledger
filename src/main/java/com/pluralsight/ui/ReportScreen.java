package com.pluralsight.ui;

import com.pluralsight.Main;
import com.pluralsight.model.TransactionApp;
import com.pluralsight.service.ReportFilter;
import com.pluralsight.util.AnsiCode;

import java.util.ArrayList;

import static com.pluralsight.util.CommonUtils.formatSpaces;

public class ReportScreen {

    public static void display(ArrayList<TransactionApp> transaction ) {

        boolean running = true;

        while (running) {

            AnsiCode.printReportScreenMenu();

            System.out.print("Enter your selection by the matching number: ");
            int userOption = Main.scanner.nextInt();
            Main.scanner.nextLine();

            switch (userOption) {
                case 1 -> ReportFilter.monthToDate(transaction);
                case 2 -> ReportFilter.previousMonth(transaction);
                case 3 -> ReportFilter.yearToDate(transaction);
                case 4 -> ReportFilter.previousYear(transaction);
                case 5 -> {
                    System.out.print("What vendor are you looking for today?: ");
                    String vendor = Main.scanner.nextLine();
                    ReportFilter.searchByVendor(transaction, vendor);
                }
                case 0 -> running = false;

                default ->{
                    System.out.println("You can't sit with us.\uD83D\uDC85\uD83D\uDC6F press enter to try again.");
                    Main.scanner.nextLine();
                    formatSpaces();
                }

            }
        }
    }
}
