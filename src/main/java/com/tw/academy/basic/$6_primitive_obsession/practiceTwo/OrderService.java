package com.tw.academy.basic.$6_primitive_obsession.practiceTwo;


import java.util.HashMap;

public class OrderService {

    /**
     * 已预定
     */
    public HashMap<String, HashMap<String, HashMap<String, Integer>>> ordered = new HashMap<>();

    public String order(String id, String month, String time) {
        String[] timeArr = time.split("~");

        if (hasBeenOrdered(id, month, timeArr)){
            return "Error: something wrong, please call the manager.";
        }

        HashMap<String, Integer> timeMap = new HashMap<>();
        timeMap.put("max", Integer.parseInt(timeArr[1].split(":")[0]));
        timeMap.put("min", Integer.parseInt(timeArr[0].split(":")[0]));
        HashMap<String, HashMap<String, Integer>> monthMap = new HashMap<>();
        monthMap.put(month, timeMap);
        ordered.put(id, monthMap);
        return "Success! You can use the No." + id + " court during " + month + " " + time + ".";
    }

    public Boolean hasBeenOrdered(String id, String month, String[] timeArr) {
        HashMap<String, HashMap<String, Integer>> countHasBook = ordered.getOrDefault(id, null);
        if (countHasBook != null) {
            HashMap<String, Integer> countHasBookInThisMonth = countHasBook.getOrDefault(month, null);
            if (countHasBookInThisMonth != null) {
                if (countHasBookInThisMonth.get("min") <= (Integer) Integer.parseInt(timeArr[0].split(":")[0])
                        && (Integer) Integer.parseInt(timeArr[0].split(":")[0]) <= countHasBookInThisMonth.get("max")) {
                    return true;
                }
                if (countHasBookInThisMonth.get("min") <= (Integer) Integer.parseInt(timeArr[1].split(":")[0])
                        && (Integer) Integer.parseInt(timeArr[1].split(":")[0]) <= countHasBookInThisMonth.get("max")) {
                    return true;
                }
            }
        }
        return false;
    }

    /* other functions */
}
