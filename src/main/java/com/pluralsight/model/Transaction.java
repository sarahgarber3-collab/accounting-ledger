package com.pluralsight.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Transaction {

    public static ArrayList<TransactionApp> loadTransaction () {

        ArrayList<TransactionApp> transaction = new ArrayList<>();
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/transactions.csv"));
            String transactionItem;
            bufReader.readLine();
            while ((transactionItem = bufReader.readLine()) != null) {
                String[] splitTransactionItem = transactionItem.split("\\|");
                LocalDate date = LocalDate.parse(splitTransactionItem[0]);
                LocalTime time = LocalTime.parse(splitTransactionItem[1]);
                String description = splitTransactionItem[2];
                String vendor = splitTransactionItem[3];
                double amount = Double.parseDouble(splitTransactionItem[4]);

                TransactionApp transactions = new TransactionApp(date,time,description,vendor,amount);
                transaction.add(transactions);

            }
            Collections.reverse(transaction);
            bufReader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transaction;
    }
}
