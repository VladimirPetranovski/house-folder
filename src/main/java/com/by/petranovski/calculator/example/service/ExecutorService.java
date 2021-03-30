package com.by.petranovski.calculator.example.service;

public class ExecutorService {

    private final MethodsService methodsService;

    public ExecutorService(MethodsService methodsService) {
        this.methodsService = methodsService;
    }

    public String execute(String s) throws NumberFormatException{

        String a = methodsService.divideStringToArray(s)[0];
        String b = methodsService.divideStringToArray(s)[2];
        String f = methodsService.divideStringToArray(s)[1];

        String[] arabicArray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] romanArray = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (int i = 0; i < arabicArray.length; i++) {
            if(a.equals(arabicArray[i]) && b.equals(romanArray[i]) ||
                    (a.equals(romanArray[i]) && b.equals(arabicArray[i]))) {
                throw new NumberFormatException("Enter one more time, because numbers can be only arabic or only roman");
            } else if(a.equals(arabicArray[i])) {
                if (Integer.parseInt(a) > 0 && Integer.parseInt(a) < 11 &&
                        Integer.parseInt(b) > 0 && Integer.parseInt(b) < 11) {
                    return methodsService.getStringResultForArabicNumerals(a, b, f);
                }
                throw new NumberFormatException("Enter another numbers, it can be arabic only from 1 to 10");
            } else if(a.equals(romanArray[i])) {
                if (methodsService.convertRomanToArabicNumerals(a) > 0 && methodsService.convertRomanToArabicNumerals(a) < 11 &&
                        methodsService.convertRomanToArabicNumerals(b) > 0 && methodsService.convertRomanToArabicNumerals(b) < 11) {
                    Integer c = methodsService.convertRomanToArabicNumerals(a);
                    Integer d = methodsService.convertRomanToArabicNumerals(b);
                    return methodsService.getStringResultForRomanNumerals(c, d, f);
                }
            }
        }
        throw new NumberFormatException("Enter one more time, because arabic's numbers can be only from 1 to 10 or roman's number can be only from I to X");
    }
}
