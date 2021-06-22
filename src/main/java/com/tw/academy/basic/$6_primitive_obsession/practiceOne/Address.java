package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class Address {
    private final String address;
    private String city;
    private String province;

    public Address(String address) {
        this.address = address;
        this.city = address.substring(address.indexOf("省") + 1, address.indexOf("市"));
        this.province = address.substring(0, address.indexOf("省"));
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getAddress() {
        return address;
    }

    String getCity(String address) {
        return address.substring(address.indexOf("省") + 1, address.indexOf("市"));
    }

    String getProvince(String address) {
        return address.substring(0, address.indexOf("省"));
    }
}
