package com.pluralsight.util;

import com.pluralsight.model.TransactionApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TransactionWriter {

    public static void Writer(TransactionApp transaction) {
        try {
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv", true));
            bufWriter.newLine();
            bufWriter.write(transaction.formatCSV());
            bufWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
