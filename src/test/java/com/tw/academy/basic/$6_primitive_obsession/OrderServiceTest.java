package com.tw.academy.basic.$6_primitive_obsession;

import com.tw.academy.basic.$6_primitive_obsession.practiceTwo.OrderService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceTest {
    @Test
    public void should_return_success_info_when_custom_correct_book_a_court() {
        OrderService orderService = new OrderService();
        String actual = orderService.order("3", "2019-12-01", "14:00~15:00");
        String expect = "Success! You can use the No.3 court during 2019-12-01 14:00~15:00.";

        assertEquals(expect, actual);
    }

    @Test
    public void should_return_error_message_when_court_has_been_booked() {
        OrderService orderService = new OrderService();
        orderService.order("3", "2019-12-01", "14:00~15:00");

        String actual = orderService.order("3", "2019-12-01", "14:00~15:00");
        String expect = "Error: something wrong, please call the manager.";
        assertEquals(expect, actual);
    }

    @Test
    public void should_return_error_message_when_court_has_been_booked_part_time() {
        OrderService orderService = new OrderService();
        orderService.order("3", "2019-12-01", "14:00~16:00");

        String frontHalf = orderService.order("3", "2019-12-01", "13:00~15:00");
        String latterHalf = orderService.order("3", "2019-12-01", "15:00~17:00");
        String expect = "Error: something wrong, please call the manager.";
        assertEquals(expect, frontHalf);
        assertEquals(expect, latterHalf);
    }

    @Test
    public void should_return_error_message_when_court_has_been_booked_given_multiple_orders() {
        OrderService orderService = new OrderService();
        orderService.order("2", "2019-12-01", "14:00~16:00");
        orderService.order("3", "2019-11-30", "14:00~16:00");
        orderService.order("3", "2019-12-01", "09:00~10:00");
        orderService.order("3", "2019-12-01", "14:00~16:00");
        orderService.order("3", "2019-12-01", "16:00~17:00");

        String actual = orderService.order("3", "2019-12-01", "14:00~17:00");
        String expect = "Error: something wrong, please call the manager.";
        assertEquals(expect, actual);
    }
}
