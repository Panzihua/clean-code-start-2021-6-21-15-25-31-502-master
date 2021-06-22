package com.tw.academy.basic.$5_data_clumps;

public class Order {

    private User user;
    private int orderNumber;

    private final String buyerName;
    private String buyerPhoneNumber;
    private String buyerAddress;

    public Order(int orderNumber, User user) {
        this.orderNumber = orderNumber;

        this.user = user;
        this.buyerName = this.user.getBuyerName();
        this.buyerPhoneNumber = this.user.getBuyerPhoneNumber();
        this.buyerAddress = this.user.getBuyerAddress();
    }

    public String confirm(){
        return String.format("Please confirm buyer information: buyer name is %s, " +
                "buyer phone number is %s and buyer address is %s.", buyerName, buyerPhoneNumber, buyerAddress);
    }
}

