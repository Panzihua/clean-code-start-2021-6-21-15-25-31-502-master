package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class DeliveryManager {
    private final Address address1;
    private final Address address;
    String toAddress;
    String fromAddress;

    public DeliveryManager(Address address, Address address1) {
        this.address1 = address1;
        this.toAddress = this.address1.getAddress();
        this.address = address;
        this.fromAddress = this.address.getAddress();
    }

    public DeliverCenter allocate(){
        if (getProvince(toAddress).equals(getProvince(fromAddress)) && getCity(toAddress).equals(getCity(fromAddress))){
            return DeliverCenter.LOCAL;
        }
        if (getProvince(toAddress).equals(getProvince(fromAddress))) {
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
