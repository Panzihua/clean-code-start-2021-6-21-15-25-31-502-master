package com.tw.academy.basic.$4_naming.practiceTwo;

public class PigLatin {
    //Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
    public static String pigIt(String input) {
        String[] markArray={".",",","-",":",";","!","?"};
        String[] stringArray = input.split(" ");
        char firstCharOfFiestStringArray;
        boolean flag = true;

        for (int stringArrayIndex = 0; stringArrayIndex < stringArray.length; stringArrayIndex++){
            for (String mark : markArray) {
                if (stringArray[stringArrayIndex].contains(mark)) {
                    flag = false;
                    break;
                }
            }

            if (flag){
                firstCharOfFiestStringArray = stringArray[stringArrayIndex].charAt(0);
                stringArray[stringArrayIndex] = stringArray[stringArrayIndex].substring(1);
                stringArray[stringArrayIndex] = stringArray[stringArrayIndex].replace(stringArray[stringArrayIndex], stringArray[stringArrayIndex] + firstCharOfFiestStringArray + "ay");
            }
            flag = true;
        }

        return String.join(" ", stringArray);
    }
}
