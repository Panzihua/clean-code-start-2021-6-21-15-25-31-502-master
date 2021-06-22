package com.tw.academy.basic.$1_dead_code;

import java.util.ArrayList;
import java.util.List;

//Has been used in somewhere
public class Car {
    private List<Passenger> passengers = new ArrayList<>();
    private static Integer seatNumber = 1;

    //Has been used in somewhere
    public void takeOn(String name, String phone, String identifyNumber) {
        Passenger passenger = new Passenger(seatNumber.toString(), name, phone, identifyNumber);
        passengers.add(passenger);
        seatNumber++;
    }
}
