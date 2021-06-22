package com.tw.academy.basic.$2_magic_number;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FareCalculationTest {
    @Test
    public void should_return_original_price_when_cumulativeExpenses_is_less_than_100() {
        double originalPrice = 5;
        double cumulativeExpensesThisMonth = 0;

        double price = new FareCalculation().calculate(originalPrice, cumulativeExpensesThisMonth);

        assertThat(price).isEqualTo(originalPrice);
    }

    @Test
    public void should_return_discounted_price_when_cumulativeExpenses_is_more_than_100_and_less_than_150() {
        double originalPrice = 5;
        double cumulativeExpensesThisMonth = 100;
        double expectPrice = 4;

        double price = new FareCalculation().calculate(originalPrice, cumulativeExpensesThisMonth);

        assertThat(price).isEqualTo(expectPrice);
    }

    @Test
    public void should_return_discounted_price_when_cumulativeExpenses_is_more_than_150_and_less_than_400() {
        double originalPrice = 5;
        double cumulativeExpensesThisMonth = 150;
        double expectPrice = 2.5;

        double price = new FareCalculation().calculate(originalPrice, cumulativeExpensesThisMonth);

        assertThat(price).isEqualTo(expectPrice);
    }

    @Test
    public void should_return_original_price_when_cumulativeExpenses_is_more_than_400() {
        double originalPrice = 5;
        double cumulativeExpensesThisMonth = 400;

        double price = new FareCalculation().calculate(originalPrice, cumulativeExpensesThisMonth);

        assertThat(price).isEqualTo(originalPrice);
    }
}
