package com.nist.kidwatcher;

import java.util.Arrays;

public class WordAnalyzer
{
    public static void AnalyzeSMS(String string)
    {
        if (AnalyzeString(string))
        {
            new Mail(Arrays.asList("Nicklasj25@hotmail.com"), string).execute();
        }
    }

    private static boolean AnalyzeString(String string)
    {
        //TODO: Hent ord fra indstillingerne
        String[] words = {"Test1", "Test2", "Test3"};
        for (String word : words)
        {
            if (string.toLowerCase().contains(word.toLowerCase()))
            {
                return true;
            }
        }
        return false;
    }
}
