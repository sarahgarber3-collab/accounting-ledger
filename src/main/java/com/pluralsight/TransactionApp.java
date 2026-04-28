package com.pluralsight;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TransactionApp {
    private LocalDate date;
    private LocalTime time;
    private String description, vendor;
    private double amount;

    public TransactionApp(LocalDate date, LocalTime time, String description, String vendor, Double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;

    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public double getAmount() {
        return amount;
    }
    public String formatCSV() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeFormatted = timeFormatter.format(this.time);
        return date + "|" + timeFormatted + "|" + description + "|" + vendor + "|" + amount;
    }
    public void printTransaction(){
        NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
        String amountFormatted = moneyFormatter.format(this.amount);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeFormatted = timeFormatter.format(this.time);
        System.out.printf("%s| %s| %s| %s| %s%n", timeFormatted, this.date, this.description, this.vendor, amountFormatted);
    }
}
