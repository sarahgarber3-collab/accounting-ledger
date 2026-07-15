package com.pluralsight.util;

import com.pluralsight.service.MovieQuotes;

public class AnsiCode {
    // ANSI COLORS
    public static final String RESET = "\u001B[0m";

    public static final String CYAN = "\u001B[96m";
    public static final String GREEN = "\u001B[92m";
    public static final String MAGENTA = "\u001B[95m";
    public static final String WHITE = "\u001B[97m";
    public static final String GRAY = "\u001B[37m";
    public static final String RED = "\u001B[91m";
    public static final String YELLOW = "\u001B[93m";
    public static final String ICE = "\u001B[38;5;123m";
    public static final String SILVER = "\u001B[38;5;250m";

    public static final String BOLD = "\u001B[1m";

    private static final int WIDTH = 54; // characters between the corners

    public static void printTop() {
        System.out.println(GRAY + BOLD + "╔" + "═".repeat(WIDTH) + "╗" + RESET);
    }

    public static void printMiddle() {
        System.out.println(GRAY + BOLD + "╟" + "─".repeat(WIDTH) + "╢" + RESET);
    }

    public static void printBottom() {
        System.out.println(GRAY+ BOLD + "╚" + "═".repeat(WIDTH) + "╝" + RESET);
    }

    private static void printRow(String text, String color, int extraPadding) {
        int padding = WIDTH - text.length() - extraPadding;
        if (padding < 0) padding = 0;
        System.out.println(GRAY + BOLD + "║" + RESET + color
                + text + " ".repeat(padding)
                + GRAY + BOLD + "║" + RESET);
    }

    private static void printMenuRow(String letter, String letterColor, String label) {
        String visibleText = " [" + letter + "] " + label; // plain text, used only for padding math
        int padding = WIDTH - visibleText.length();
        if (padding < 0) padding = 0;

        System.out.println(GRAY + BOLD + "║" + RESET
                + " " + SILVER + "[" + letterColor + letter + SILVER + "]" + RESET
                + " " + WHITE + label + " ".repeat(padding) + RESET
                + GRAY + BOLD + "║" + RESET);
    }


    // New Code For Custom Starter Screen Added By Syd
// New Code For Custom Starter Screen Added By Syd
    public static void displayStartScreen() {
        String red = "\u001B[31m";
        String gold = "\u001B[33m";
        String reset = "\u001B[0m";

        try {
            // Part 1: movie screen countdown
            for (int i = 3; i >= 1; i--) {
                System.out.println(gold + i + "..." + reset);
                Thread.sleep(800);
            }
            System.out.println();

            // Part 2: marquee design to look like a real movie title
            System.out.println("  ⭐  🌟  ⭐  🌟  ⭐  🌟  ⭐  🌟  ⭐  🌟  ⭐");
            System.out.println("🔴\uD83D\uDCA1🔴🟡🔴🟡🔴🟡🔴🟡🔴🟡🔴🟡🔴🟡🔴🟡🔴🟡🔴🟡");
            System.out.println(red  + "|" + reset + "                                            " + gold + "|" + reset);
            System.out.println(gold + "|" + reset + "        THE CINEMA ACCOUNTING LEDGER        " + red  + "|" + reset);
            System.out.println(red  + "|" + reset + "                                            " + gold + "|" + reset);
            System.out.println("🔴🟡🔴🟡🔴🟡🔴🟡🔴🟡🔴🟡🔴🟡🔴🟡🔴🟡🔴🟡🔴🟡");
            System.out.println(gold + "|" + reset + "   NOW SHOWING: Random movie quotes may     " + red  + "|" + reset);
            System.out.println(red  + "|" + reset + "   appear! Guess where the quote came       " + gold + "|" + reset);
            System.out.println(gold + "|" + reset + "   from to test your cinema knowledge!       " + red  + "|" + reset);
            System.out.println("🔴🟡🔴🟡🔴🟡🔴🟡🔴🟡🔴🟡🔴🟡🔴🟡🔴🟡🔴🟡🔴🟡");
            System.out.println("  ⭐  🌟  ⭐  🌟  ⭐  🌟  ⭐  🌟  ⭐  🌟  ⭐");
            System.out.println();

            Thread.sleep(500);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Part 3: hand off to the boxed header for the details
        printHomeScreenMenu();
    }

    //HomeScreen Menu
    public static void printHomeScreenMenu() {
        printTop();
        printRow(" ---HOME SCREEN---", SILVER + BOLD, 0);
        printMiddle();
        printMenuRow("D", YELLOW + BOLD, "Add Deposit");
        printMenuRow("P", YELLOW + BOLD, "Make A Payment (Debit)");
        printMenuRow("L", YELLOW + BOLD, "Ledger");
        printMenuRow("X", YELLOW + BOLD, "Exit The Application");
        printBottom();
        printSelection();
    }

    // LedgerScreen Menu
    public static void printLedgerScreenMenu() {
        printTop();
        printRow(" ---LEDGER SCREEN---", SILVER + BOLD, 0);
        printMiddle();
        printMenuRow("A", YELLOW + BOLD, "All - Display all entries");
        printMenuRow("D", YELLOW + BOLD, "Deposits - only deposit entries");
        printMenuRow("P", YELLOW + BOLD, "Payments - only payment entries");
        printMenuRow("R", YELLOW + BOLD, "Reports");
        printMenuRow("H", YELLOW + BOLD, "Home - go back to the home page");
        printBottom();
        printSelection();
    }

    // ReportScreen Menu
    public static void printReportScreenMenu() {
        printTop();
        printRow(" ---REPORT SCREEN---", SILVER + BOLD, 0);
        printMiddle();
        printMenuRow("1", YELLOW + BOLD, "Month to Date");
        printMenuRow("2", YELLOW + BOLD, "Previous Month");
        printMenuRow("3", YELLOW + BOLD, "Year to Date");
        printMenuRow("4", YELLOW + BOLD, "Previous Year");
        printMenuRow("5", YELLOW + BOLD, "Search by Vendor");
        printMenuRow("6", YELLOW + BOLD, "Summary (Income/Expenses/Net)");
        printMenuRow("7", YELLOW + BOLD, "Custom Search");
        printMenuRow("0", YELLOW + BOLD, "Back - go back to the ledger page");
        printBottom();
        printSelection();
    }

    // GoodByes
    public static void exitHome(){
        System.out.println(YELLOW + BOLD + "Thanks for using The Cinema Accounting Ledger, Have a nice day!"+ RESET);
        System.out.println(RED + BOLD + MovieQuotes.getRandomExitQuote());
    }

    // Invalids
    public static void printInvalid(){
        System.out.printf(YELLOW + BOLD +  "%-44s%n" + RESET, MovieQuotes.getRandomErrorQuote() + "press enter to try again.");
    }


    public static void printSelection(){
        System.out.print(GRAY + BOLD + "Enter Selection: " + RESET + WHITE);
    }







}
