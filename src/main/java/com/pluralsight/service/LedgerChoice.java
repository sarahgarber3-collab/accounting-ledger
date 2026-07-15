package com.pluralsight.service;
import java.util.ArrayList;
import com.pluralsight.model.TransactionApp;
import com.pluralsight.util.CommonUtils;

public class LedgerChoice {

    public static void ledgerChoice(ArrayList<TransactionApp> transactions, String filter) {

        for (TransactionApp t : transactions) {
            if (filter.equalsIgnoreCase("all")) {
                t.printTransaction();
            } else if (filter.equalsIgnoreCase("deposits") && t.getAmount() > 0) {
                t.printTransaction();
            } else if (filter.equalsIgnoreCase("payments") && t.getAmount() < 0) {
                t.printTransaction();
            }
        }
        CommonUtils.formatSpaces();
    }
    private static void printRunningBalance(ArrayList<TransactionApp> transactions){
        double runningBalance = 0;
        NumberFormat money = NumberFormat.getCurrencyInstance();

        double[] balances = new double[transactions.size()];
        for(int i = transactions.size() - 1; i >= 0; i--){
            runningBalance += transactions.get(i).getAmount();
            balance[i] = runningBalance;
        }

        for(int i = 0; i < transactions.size(); i++){
            System.out.printf("Balance: %s  ", money.format(balances[i]));
            transactions.get(i).printTransaction();
        }
    }
}
