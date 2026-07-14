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
}
