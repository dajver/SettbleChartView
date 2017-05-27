package com.project.chartview.etc;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by gleb on 5/27/17.
 */

public class SharedPrefs {

    private static final String FIRST_PIE = "firstPie";
    private static final String SECOND_PIE = "secondPie";
    private static final String THIRD_PIE = "thirdPie";
    private static final String FORTH_PIE = "forthPie";
    private static final String FIFTH_PIE = "fifthPie";
    private static final String SIXTH_PIE = "sixthPie";
    private static final String SEVENTH_PIE = "seventhPie";
    private static final String EIGHTH_PIE = "eigthPie";

    public static void setPieCharts(Context context, int[] val) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putInt(FIRST_PIE, val[0])
                .putInt(SECOND_PIE, val[1])
                .putInt(THIRD_PIE, val[2])
                .putInt(FORTH_PIE, val[3])
                .putInt(FIFTH_PIE, val[4])
                .putInt(SIXTH_PIE, val[5])
                .putInt(SEVENTH_PIE, val[6])
                .putInt(EIGHTH_PIE, val[7])
                .commit();
    }

    public static int[] getPieCharts(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        int[] pieCharts = new int[8];
        pieCharts[0] = preferences.getInt(FIRST_PIE, 0);
        pieCharts[1] = preferences.getInt(SECOND_PIE, 0);
        pieCharts[2] = preferences.getInt(THIRD_PIE, 0);
        pieCharts[3] = preferences.getInt(FORTH_PIE, 0);
        pieCharts[4] = preferences.getInt(FIFTH_PIE, 0);
        pieCharts[5] = preferences.getInt(SIXTH_PIE, 0);
        pieCharts[6] = preferences.getInt(SEVENTH_PIE, 0);
        pieCharts[7] = preferences.getInt(EIGHTH_PIE, 0);
        return pieCharts;
    }
}
