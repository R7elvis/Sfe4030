///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package test2;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// *
// * @author Ricky
// */
//public class ConvertRoman {
//    
//    private static final Map<Character, Integer> map = new HashMap<>();
//
//    static {
//        map.put('I', 1);
//        map.put('V', 5);
//        map.put('X', 10);
//        map.put('L', 50);
//        map.put('C', 100);
//        map.put('D', 500);
//        map.put('M', 1000);
//    }
//
//    public int romanToInt(String s) {
//        int convertedNumber = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            int currentNumber = map.get(s.charAt(i));
//
//            int next = (i + 1 < s.length()) ? map.get(s.charAt(i + 1)) : 0;
//
//            if (currentNumber >= next) {
//                convertedNumber += currentNumber;
//            } else {
//                convertedNumber -= currentNumber;
//            }
//        }
//
//        return convertedNumber;
//    }
//    
//    public static void main(String[] args) {
//        
//        ConvertRoman xy = new ConvertRoman();
//        
//        String str = "MCMIV";
//        System.out.println(xy.romanToInt(str));
//        
//    }
//}
package test2;

import java.util.HashMap;
import java.util.Map;

/**
 * This class converts Roman numerals to integers and handles invalid input.
 * 
 * @author Ricky
 */
public class ConvertRoman {
    
    private static final Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0; // Return 0 for empty or null input
        }

        int convertedNumber = 0;
        int prevNumber = 0; // To keep track of the previous number
        int consecutiveCount = 0; // To count consecutive identical numerals

        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            
            if (!map.containsKey(currentChar)) {
                return -1; // Return -1 for invalid characters
            }
            
            int currentNumber = map.get(currentChar);

            if (currentNumber < prevNumber) {
                convertedNumber -= currentNumber; // Check for subtractive notation
                consecutiveCount = 0; // Reset consecutive count on subtraction
            } else {
                if (currentNumber == prevNumber) {
                    consecutiveCount++;
                    if (consecutiveCount > 2) {
                        return -1; // More than three consecutive identical numerals are not valid
                    }
                } else {
                    consecutiveCount = 0;
                }
                convertedNumber += currentNumber;
            }

            prevNumber = currentNumber;
        }

        return convertedNumber;
    }
    
    public int testValidRoman(String s) {
        return romanToInt(s);
    }
    
    public int testRepetition(String s) {
        return romanToInt(s);
    }
    
    public int testInvalidLetter(String s) {
        return romanToInt(s);
    }
    
    public int testInvalidAndValidLetter(String s) {
        return romanToInt(s);
    }
    
    public int testNotValid(String s) {
        return romanToInt(s);
    }
    
    public int testNullInput(String s) {
        return romanToInt(s);
    }
    
    public static void main(String[] args) {
        ConvertRoman xy = new ConvertRoman();
        
        String str = "MCMIV";
        System.out.println(xy.romanToInt(str));
    }
}
