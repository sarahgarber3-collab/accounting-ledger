package com.pluralsight.model;

public class TransactionValidator {

    public static void validate(String description, String vendor, double amount) throws InvalidTransactionException{
        if (description == null || description.isBlank()) {
            throw new InvalidTransactionException("Description cannot be left blank.");
        }
        if (vendor == null || vendor.isBlank()){
            throw new InvalidTransactionException("Vendor cannot be left blank.");
        }
        if (amount <= 0)
            throw new InvalidTransactionException("Amount must be greater than 0.");
    }
}
