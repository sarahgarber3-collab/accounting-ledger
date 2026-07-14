package com.pluralsight.service;

import java.text.NumberFormat;
import com.pluralsight.model.TransactionApp;
import com.pluralsight.util.CommonUtils;

import java.time.LocalDate;
import java.util.ArrayList;

public class ReportFilter {

    public static void monthToDate(ArrayList<TransactionApp> transactions) {
        for (TransactionApp t : transactions) {
            if (t.getDate().getMonth() == LocalDate.now().getMonth()
                    && t.getDate().getYear() == LocalDate.now().getYear()) {
                t.printTransaction();
            }
        }
        CommonUtils.formatSpaces();
    }

    public static void previousMonth(ArrayList<TransactionApp> transactions) {
        LocalDate lastMonth = LocalDate.now().minusMonths(1);
        for (TransactionApp t : transactions) {
            if (t.getDate().getMonth() == lastMonth.getMonth()
                    && t.getDate().getYear() == lastMonth.getYear()) {
                t.printTransaction();
            }
        }
        CommonUtils.formatSpaces();
    }

    public static void yearToDate(ArrayList<TransactionApp> transactions) {
        for (TransactionApp t : transactions) {
            if (t.getDate().getYear() == LocalDate.now().getYear()) {
                t.printTransaction();
            }
        }
        CommonUtils.formatSpaces();
    }

    public static void previousYear(ArrayList<TransactionApp> transactions) {
        int lastYear = LocalDate.now().minusYears(1).getYear();
        for (TransactionApp t : transactions) {
            if (t.getDate().getYear() == lastYear) {
                t.printTransaction();
            }
        }
        CommonUtils.formatSpaces();
    }

    public static void searchByVendor(ArrayList<TransactionApp> transactions, String vendor) {
        for (TransactionApp t : transactions) {
            if (t.getVendor().equalsIgnoreCase(vendor)) {
                t.printTransaction();
            }
        }
        CommonUtils.formatSpaces();
    }
    public static void summary(ArrayList<TransactionApp> transactions){
        double totalIncome = 0;
        double totalExpenses = 0;

        for (TransactionApp t : transactions){
            if(t.getAmount() > 0){
                totalIncome += t.getAmount();
            }else{
                totalExpenses += t.getAmount();
            }
        }
        NumberFormat money = NumberFormat.getCurrencyInstance();
        System.out.println("======SUMMARY======");
        System.out.println("Total Income:  " + money.format(totalIncome));
        System.out.println("Total Expenses:  " + money.format(totalExpenses));
        System.out.println("Net:  " + money.format(totalIncome + totalExpenses));
        CommmonUtils.formatSpaces();
    }
    
}
