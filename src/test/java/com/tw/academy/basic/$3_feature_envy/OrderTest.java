package com.tw.academy.basic.$3_feature_envy;

import com.tw.academy.basic.$3_feature_envy.practiceTwo.LineItem;
import com.tw.academy.basic.$3_feature_envy.practiceTwo.Order;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    @Test
    public void should_return_total_price() {
        LineItem apple = new LineItem("apple", 12.5, 2);
        LineItem egg = new LineItem("egg", 4.0, 3);
        List<LineItem> shoppingCart = new ArrayList<>();
        shoppingCart.add(apple);
        shoppingCart.add(egg);
        Order order = new Order("Tom", "#123", shoppingCart);

        double actual = order.calculateTotalPrice();

        assertEquals(37, actual);
    }
}
