package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class DeliveryManager {
    private final Address fromAddress;
    private final Address toAddress;

    public DeliveryManager(Address toAddress, Address fromAddress) {
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
    }

    public DeliverCenter allocate(){
        if (getProvince(this.fromAddress.getAddress()).equals(getProvince(this.toAddress.getAddress())) && getCity(this.fromAddress.getAddress()).equals(getCity(this.toAddress.getAddress()))){
            return DeliverCenter.LOCAL;
        }
        if (getProvince(this.fromAddress.getAddress()).equals(getProvince(this.toAddress.getAddress()))) {
            return DeliverCenter.PROVINCE;
        }
        return DeliverCenter.FOREIGN;
    }

    private String getCity(String address) {
        return address.substring(address.indexOf("省") + 1, address.indexOf("市"));
    }

    private String getProvince(String address) {
        return address.substring(0, address.indexOf("省"));
    }
}
