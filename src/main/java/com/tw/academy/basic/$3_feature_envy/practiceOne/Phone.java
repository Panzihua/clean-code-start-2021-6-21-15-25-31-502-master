package com.tw.academy.basic.$3_feature_envy.practiceOne;

public class Phone {
    public Phone(String areaCode, String prefix, String number) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.number = number;
    }

    private final String areaCode;
    private final String prefix;
    private final String number;

    public String getAreaCode() {
        return areaCode;
    }
    public String getPrefix() {
        return prefix;
    }
    public String getNumber() {
        return number;
    }

    public String getMobilePhoneNumber() {
        return "aaa";
    }
}
