package com.pluralsight.service;

import java.util.ArrayList;
import java.util.Random;

public class MovieQuotes {

    private static ArrayList<String> errorQuotes = new ArrayList<>();
    private static ArrayList<String> exitQuotes = new ArrayList<>();
    private static Random random = new Random();

    static {
        errorQuotes.add("Houston, we have a problem. \uD83D\uDC68\u200D\uD83D\uDE80");
        errorQuotes.add("Toto, I've a feeling we're not in Kansas anymore.\uD83D\uDC36\uD83D\uDC60\uD83C\uDF2A\uFE0F");
        errorQuotes.add("You can't sit with us.\uD83D\uDC85\uD83D\uDC6F");
        errorQuotes.add("Just keep swimming.\uD83D\uDC1F");
        errorQuotes.add("You shall not pass!\uD83E\uDDD9\u200D\u2642\uFE0F");
        errorQuotes.add("Why so serious?\uD83E\uDD21");
        errorQuotes.add("Nobody puts Baby in a corner.\uD83D\uDC83");
        errorQuotes.add("There's no place like home.\uD83C\uDFE0");

        exitQuotes.add("May the force be with you.\uD83D\uDEF8\uD83C\uDF20");
        exitQuotes.add("Life is like a box of chocolates.\uD83C\uDF6B");
        exitQuotes.add("To infinity and beyond!\uD83D\uDE80");
        exitQuotes.add("Wax on, wax off. See you next time.\uD83E\uDD8E");
        exitQuotes.add("Hasta la vista, baby.\uD83D\uDC4B");
        exitQuotes.add("That's all folks!\uD83D\uDC37");
        exitQuotes.add("Roads? Where we're going, we don't need roads.\uD83D\uDE97");
    }

    public static String getRandomErrorQuote() {
        int index = random.nextInt(errorQuotes.size());
        return errorQuotes.get(index);
    }

    public static String getRandomExitQuote() {
        int index = random.nextInt(exitQuotes.size());
        return exitQuotes.get(index);
    }
}

