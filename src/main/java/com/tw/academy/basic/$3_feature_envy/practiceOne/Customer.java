package com.tw.academy.basic.$3_feature_envy.practiceOne;

public class Customer {
    private Phone mobilePhone;

    public Customer(Phone mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getMobilePhoneNumber() {
        return "(" +
                mobilePhone.getAreaCode() + ") " +
                mobilePhone.getPrefix() + "-" +
                mobilePhone.getNumber();
    }
}
