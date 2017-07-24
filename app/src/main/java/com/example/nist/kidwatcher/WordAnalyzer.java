package com.example.nist.kidwatcher;

import android.util.Log;

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
                Log.d(TAG, "Fy-ord fundet!!!");
                Mail.SendMail("SMS", string);
            }
            return;
        }
    }
}
