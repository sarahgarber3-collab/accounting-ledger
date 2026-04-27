package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

public class TransactionApp {
    private LocalDate date;
    private LocalTime time;
    private String description, vendor;
    private Double amount;

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

    public Double getAmount() {
        return amount;
    }
    public String formatCSV() {
        return date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
    }
}
