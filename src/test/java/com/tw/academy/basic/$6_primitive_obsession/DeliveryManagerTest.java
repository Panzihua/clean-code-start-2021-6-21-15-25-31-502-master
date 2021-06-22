package com.tw.academy.basic.$6_primitive_obsession;
import com.tw.academy.basic.$6_primitive_obsession.practiceOne.Address;
import com.tw.academy.basic.$6_primitive_obsession.practiceOne.DeliverCenter;
import com.tw.academy.basic.$6_primitive_obsession.practiceOne.DeliveryManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryManagerTest {
    @Test
    public void should_allocate_to_local_when_target_address_same_with_mailing_address() {
        String mailingAddress = "湖北省武汉市江汉区解放大道1277号";
        String targetAddress = "湖北省武汉市硚口区解放大道1095号";
        DeliveryManager deliveryManager = new DeliveryManager(new Address(mailingAddress), new Address(targetAddress));

        DeliverCenter actual = deliveryManager.allocate();

        assertEquals(DeliverCenter.LOCAL, actual);
    }

    @Test
    public void should_allocate_to_province_when_target_address_and_mailing_address_in_same_province() {
        String mailingAddress = "湖北省武汉市江汉区解放大道1277号";
        String targetAddress = "湖北省十堰市丹江口市太和街道永乐路13号";
        DeliveryManager deliveryManager = new DeliveryManager(new Address(mailingAddress), new Address(targetAddress));

        DeliverCenter actual = deliveryManager.allocate();

        assertEquals(DeliverCenter.PROVINCE, actual);
    }

    @Test
    public void should_allocate_to_foreign_when_target_address_and_mailing_address_in_different_province() {
        String mailingAddress = "四川省成都市武侯区国学巷37号";
        String targetAddress = "湖北省武汉市江汉区解放大道1277号";
        DeliveryManager deliveryManager = new DeliveryManager(new Address(mailingAddress), new Address(targetAddress));

        DeliverCenter actual = deliveryManager.allocate();

        assertEquals(DeliverCenter.FOREIGN, actual);
    }
}
