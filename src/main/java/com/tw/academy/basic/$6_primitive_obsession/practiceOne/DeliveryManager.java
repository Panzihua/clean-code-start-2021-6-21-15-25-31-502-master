package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class DeliveryManager {
    private final Address fromAddress;
    private final Address toAddress;

    public DeliveryManager(Address toAddress, Address fromAddress) {
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
    }

    public DeliverCenter allocate(){
        if (fromAddress.getProvince().equals(toAddress.getProvince()) && fromAddress.getCity().equals(toAddress.getCity())){
            return DeliverCenter.LOCAL;
        }
        if (fromAddress.getProvince().equals(toAddress.getProvince())) {
            return DeliverCenter.PROVINCE;
        }
        return DeliverCenter.FOREIGN;
    }

}
