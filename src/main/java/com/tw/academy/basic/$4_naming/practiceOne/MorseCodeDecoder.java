package com.tw.academy.basic.$4_naming.practiceOne;

public class MorseCodeDecoder {
    public static String decode(String input) {
        String[] tempValue = input.split("\\s{2,}");
        StringBuilder res = new StringBuilder();
        for (String s : tempValue) {
            String [] charArray = s.split(" ");
            for (String c: charArray) {
                res.append(MorseCode.get(c));
            }
            res.append(" ");
        }
        return res.toString().replaceAll("null", "").trim();
    }
}
