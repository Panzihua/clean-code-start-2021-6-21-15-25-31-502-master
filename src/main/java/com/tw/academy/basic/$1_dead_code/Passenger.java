package com.tw.academy.basic.$1_dead_code;

//only be used in Car
public class Passenger {
    private String seatNumber;
    private String name;
    private String phone;
    private String identityNumber;


    public Passenger(String seatNumber, String name) {
        this.seatNumber = seatNumber;
        this.name = name;
    }

//    public Passenger(String seatNumber, String name, String phone) {
//        this.seatNumber = seatNumber;
//        this.name = name;
//        this.phone = phone;
//    }

    public Passenger(String seatNumber, String name, String phone, String identityNumber) {
        this.seatNumber = seatNumber;
        this.name = name;
        this.phone = phone;
        this.identityNumber = identityNumber;
    }
}
