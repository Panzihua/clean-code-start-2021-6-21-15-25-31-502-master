package com.tw.academy.basic.$2_magic_number;

public class FareCalculation {

    public static final int EIGHTY_PERCENT_OFF_MIN_BORDER = 100;
    public static final int EIGHTY_PERCENT_OFF_MAX_BORDER = 150;
    public static final int FIFTY_PERCENT_OFF_MIN_BORDER = 150;
    public static final int FIFTY_PERCENT_OFF_MAX_BORDER = 400;
    public static final double EIGHTY_PERCENT_OFF = 0.8;
    public static final double FIFTY_PERCENT_OFF = 0.5;

    public double calculate(double originalPrice, double cumulativeExpensesThisMonth) {
        if (cumulativeExpensesThisMonth >= EIGHTY_PERCENT_OFF_MIN_BORDER && cumulativeExpensesThisMonth < EIGHTY_PERCENT_OFF_MAX_BORDER) {
            return originalPrice * EIGHTY_PERCENT_OFF;
        }
        if (cumulativeExpensesThisMonth >= FIFTY_PERCENT_OFF_MIN_BORDER && cumulativeExpensesThisMonth < FIFTY_PERCENT_OFF_MAX_BORDER) {
            return originalPrice * FIFTY_PERCENT_OFF;
        }
        return originalPrice;
    }
}
