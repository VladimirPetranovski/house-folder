package com.by.petranovski.calculator.example.service;

public class MethodsService {

    protected int convertRomanToArabicNumerals (String number) {
        String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int result = 0;
        for (int j = 0; j < romanNumbers.length; j++) {
            if (romanNumbers[j].equals(number)) {
                result = j + 1;
            }
        }
        return result;
    }

    protected String convertArabicToRomanNumeral(int input) {
        if (input < 1 || input > 3999)
            return "Invalid Roman Number Value";
        StringBuilder s = new StringBuilder();
        while (input >= 1000) {
            s.append("M");
            input -= 1000;        }
        while (input >= 900) {
            s.append("CM");
            input -= 900;
        }
        while (input >= 500) {
            s.append("D");
            input -= 500;
        }
        while (input >= 400) {
            s.append("CD");
            input -= 400;
        }
        while (input >= 100) {
            s.append("C");
            input -= 100;
        }
        while (input >= 90) {
            s.append("XC");
            input -= 90;
        }
        while (input >= 50) {
            s.append("L");
            input -= 50;
        }
        while (input >= 40) {
            s.append("XL");
            input -= 40;
        }
        while (input >= 10) {
            s.append("X");
            input -= 10;
        }
        while (input >= 9) {
            s.append("IX");
            input -= 9;
        }
        while (input >= 5) {
            s.append("V");
            input -= 5;
        }
        while (input >= 4) {
            s.append("IV");
            input -= 4;
        }
        while (input >= 1) {
            s.append("I");
            input -= 1;
        }
        return s.toString();
    }

    protected String[] divideStringToArray(String s) {
        return s.split(" ");
    }

    protected String getStringResultForArabicNumerals(String a, String b, String f) {
        switch (f) {
            case "+":
                return String.valueOf(Integer.parseInt(a) + Integer.parseInt(b));
            case "-":
                return String.valueOf(Integer.parseInt(a) - Integer.parseInt(b));
            case "*":
                return String.valueOf(Integer.parseInt(a) * Integer.parseInt(b));
            case "/":
                return String.valueOf(Integer.parseInt(a) / Integer.parseInt(b));
        }
        throw new NumberFormatException("The calculator can use only +, -, *, / operators");
    }

    protected String getStringResultForRomanNumerals(Integer c, Integer d, String f) {
        switch (f) {
            case "+":
                return convertArabicToRomanNumeral(c + d);
            case "-":
                return convertArabicToRomanNumeral(c - d);
            case "*":
                return convertArabicToRomanNumeral(c * d);
            case "/":
                return convertArabicToRomanNumeral(c / d);
        }
        throw new NumberFormatException("The calculator can use only +, -, *, / operators");
    }
}
