package com.tw.academy.basic.$5_data_clumps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    @Test
    public void should_confirm_receiver_information_with_buyer(){
        Order order = new Order(1, new User("Tom", "13132323232", "Wuhan"));
        String confirmMessage = order.confirm();
        String expect = "Please confirm buyer information: buyer name is Tom, buyer phone number is 13132323232 and buyer address is Wuhan.";

        assertEquals(expect, confirmMessage);
    }
}
