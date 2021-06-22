package com.tw.academy.basic.$3_feature_envy;

import com.tw.academy.basic.$3_feature_envy.practiceOne.Customer;
import com.tw.academy.basic.$3_feature_envy.practiceOne.Phone;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    @Test
    public void should_return_format_phone_number(){
        Phone phone = new Phone("123", "456", "7890");
        Customer customer = new Customer(phone);
        String actual = customer.getMobilePhoneNumber();

        assertEquals("(123) 456-7890", actual);
    }
}
