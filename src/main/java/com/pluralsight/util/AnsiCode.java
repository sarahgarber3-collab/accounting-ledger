package com.pluralsight.util;

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


    // HomeScreen Header
    public static void printHomeScreenHeader() {
        printTop();
        printRow(" \uD83D\uDCB0 Welcome to The Cinema Accounting Ledger! \uD83D\uDCB0", WHITE + BOLD, 2);
        printMiddle();
        printRow(" Random movie quotes may appear. \uD83C\uDFA5\uD83C\uDF7F", GRAY, 2);
        printRow(" Guess where the quote came from to test your", GRAY, 0);
        printRow(" cinema knowledge \uD83C\uDFAC\uD83C\uDFC6", GRAY, 2);
        printBottom();
    }

    //HomeScreen Menu
    public static void printHomeScreenMenu() {
        printTop();
        printRow(" ---HOME SCREEN---", SILVER + BOLD, 0);
        printMiddle();
        printMenuRow("D", GREEN, "Add Deposit");
        printMenuRow("P", YELLOW, "Make A Payment (Debit)");
        printMenuRow("L", CYAN, "Ledger");
        printMenuRow("X", RED, "Exit The Application");
        printBottom();
        printSelection();
    }

    // LedgerScreen Menu
    public static void printLedgerScreenMenu() {
        printTop();
        printRow(" ---LEDGER SCREEN---", SILVER + BOLD, 0);
        printMiddle();
        printMenuRow("A", ICE, "All - Display all entries");
        printMenuRow("D", GREEN, "Deposits - only deposit entries");
        printMenuRow("P", YELLOW, "Payments - only payment entries");
        printMenuRow("R", CYAN, "Reports");
        printMenuRow("H", RED, "Home - go back to the home page");
        printBottom();
        printSelection();
    }

    // ReportScreen Menu
    public static void printReportScreenMenu() {
        printTop();
        printRow(" ---REPORT SCREEN---", SILVER + BOLD, 0);
        printMiddle();
        printMenuRow("1", MAGENTA, "Month to Date");
        printMenuRow("2", ICE, "Previous Month");
        printMenuRow("3", GREEN, "Year to Date");
        printMenuRow("4", YELLOW, "Previous Year");
        printMenuRow("5", CYAN, "Search by Vendor");
        printMenuRow("0", RED, "Back - go back to the ledger page");
        printBottom();
        printSelection();
    }

    // GoodByes
    public static void exitHome(){
        System.out.println(MAGENTA + BOLD + "Thanks for using The Cinema Accounting Ledger, Have a nice day!"+ RESET);
        System.out.println("May the force be with you.\uD83D\uDEF8\uD83C\uDF20");
    }

    public static void exitLedgerScreen() {
        System.out.println("Toto, I've a feeling we're not in Kansan anymore.\uD83D\uDC36\uD83D\uDC60\uD83C\uDF2A\uFE0F press enter to try again.");
    }
    public static void exitReportScreen() {
        System.out.println("You can't sit with us.\uD83D\uDC85\uD83D\uDC6F press enter to try again.");
    }

    // Invalids
    public static void printInvalid(){
        System.out.printf(MAGENTA +  "%-44s%n" + RESET,"Houston, we have a problem. \n press enter to try again.");
    }

    public static void printSelection(){
        System.out.print(GRAY + BOLD + "Enter Selection: " + RESET + WHITE);
    }







}
