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
                case 6 -> ReportFilter.summary(transaction);
                case 7 -> {
                    System.out.print("Enter start date (yyyy-MM-dd), or press Enter to skip: ");
                    String startDateInput = Main.scanner.nextLine();

                    System.out.print("Enter end date (yyyy-MM-dd), or press Enter to skip: ");
                    String endDateInput = Main.scanner.nextLine();

                    System.out.print("Enter description, or press Enter to skip: ");
                    String descriptionInput = Main.scanner.nextLine();

                    System.out.print("Enter vendor, or press Enter to skip: ");
                    String vendorInput = Main.scanner.nextLine();

                    System.out.print("Enter amount, or press Enter to skip: ");
                    String amountInput = Main.scanner.nextLine();

                    ReportFilter.customSearch(transaction, startDateInput, endDateInput, descriptionInput, vendorInput, amountInput);
                }
                case 0 -> running = false;

                default ->{
                    AnsiCode.printInvalid();
                    Main.scanner.nextLine();
                    formatSpaces();
                }

            }
        }
    }
}
