package com.nist.kidwatcher;

import java.util.Arrays;

public class WordAnalyzer
{
    private static String TAG = "WordAnalyzer";

    public static void AnalyzeString(String string)
    {
        //TODO: Gennemsøger tekst for fy-ord
        String[] words = {"Test1", "Test2", "Test3"};
        for (String word : words)
        {
            if (string.toLowerCase().contains(word.toLowerCase()))
            {
                new Mail(Arrays.asList("Nicklasj25@hotmail.com"), string).execute();
            }
            return;
        }
    }
}
