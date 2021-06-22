package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class DeliveryManager {
    private final Address fromAddress;
    private final Address toAddress;

    public DeliveryManager(Address toAddress, Address fromAddress) {
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
    }

    public DeliverCenter allocate(){
        if (fromAddress.getProvince(this.fromAddress.getAddress()).equals(fromAddress.getProvince(this.toAddress.getAddress())) && fromAddress.getCity(this.fromAddress.getAddress()).equals(fromAddress.getCity(this.toAddress.getAddress()))){
            return DeliverCenter.LOCAL;
        }
        if (fromAddress.getProvince(this.fromAddress.getAddress()).equals(fromAddress.getProvince(this.toAddress.getAddress()))) {
            return DeliverCenter.PROVINCE;
        }
        return DeliverCenter.FOREIGN;
    }

}
