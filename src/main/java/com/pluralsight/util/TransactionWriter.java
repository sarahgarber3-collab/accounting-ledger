package com.pluralsight.util;

import com.pluralsight.delete.TransactionApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TransactionWriter {

    public static void writeTransaction(TransactionApp transaction) {
        try {
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv", true));
            bufWriter.newLine();
            bufWriter.write(transaction.formatCSV());
            bufWriter.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void WriteTransaction(TransactionApp payment) {
    }
}
