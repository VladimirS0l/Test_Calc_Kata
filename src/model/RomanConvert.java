package model;

import java.util.TreeMap;

public class RomanConvert {
    TreeMap<Character, Integer> romanNumberMap = new TreeMap<>();
    TreeMap<Integer, String> arabNumberMap = new TreeMap<>();

    public RomanConvert(){
        romanNumberMap.put('I', 1);
        romanNumberMap.put('V', 5);
        romanNumberMap.put('X', 10);
        romanNumberMap.put('L', 50);
        romanNumberMap.put('C', 100);
        romanNumberMap.put('D', 500);
        romanNumberMap.put('M', 1000);

        arabNumberMap.put(1000, "M");
        arabNumberMap.put(900, "CM");
        arabNumberMap.put(500, "D");
        arabNumberMap.put(400, "CD");
        arabNumberMap.put(100, "C");
        arabNumberMap.put(90, "XC");
        arabNumberMap.put(50, "L");
        arabNumberMap.put(40, "XL");
        arabNumberMap.put(10, "X");
        arabNumberMap.put(9, "IX");
        arabNumberMap.put(5, "V");
        arabNumberMap.put(4, "IV");
        arabNumberMap.put(1, "I");
    }

    public boolean checkRomanNumber(String number){
        return romanNumberMap.containsKey(number.charAt(0));
    }

    public String intToRoman(int number){
        String romanNumber = "";
        int arabNumber;
        do{
            arabNumber = arabNumberMap.floorKey(number);
            romanNumber += arabNumberMap.get(arabNumber);
            number -= arabNumber;
        } while (number != 0);
        return romanNumber;

    }

    public int romanToInt(String str){
        int end = str.length() - 1;
        char[] array = str.toCharArray();
        int arabNumber;
        int result = romanNumberMap.get(array[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabNumber = romanNumberMap.get(array[i]);
            if(arabNumber < romanNumberMap.get(array[i+1])){
                result -= arabNumber;
            }else {
                result += arabNumber;
            }
        }
        return result;
    }
}
