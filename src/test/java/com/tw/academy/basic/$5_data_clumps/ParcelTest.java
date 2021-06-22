package com.tw.academy.basic.$5_data_clumps;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ParcelTest {
    @Test
    public void should_confirm_receiver_information_with_sender_when_collect_parcel() {
        Parcel parcel = new Parcel("Large", 12.5, "Tom", "13132323232", "Home",
                "Jerry","13123333333", "Hole");
        String confirmReceiverMessage = parcel.confirmReceiver();
        String receiverExpect = "Please confirm receiver information: receiver name is Tom, receiver phone number is 13132323232 and receiver address is Home.\n";

        String confirmSenderMessage = parcel.confirmSender();
        String senderExpect = "Please confirm sender information: sender name is Jerry, sender phone number is 13123333333 and sender address is Hole.\n";

        assertEquals(receiverExpect, confirmReceiverMessage);
        assertEquals(senderExpect, confirmSenderMessage);
    }
}
