package com.by.petranovski.class_string.transform_string_to_char_array;

import java.util.Arrays;

class StringToCharToString {
    public static void main(String[] args) {
        //String to char array
        String str = "123";
        char[] chArr = str.toCharArray();
        System.out.println("String to char array: "+ Arrays.toString(chArr));
        //String to char
        char c = str.charAt(1);
        System.out.println("String to char: "+c);
        //char to String
        String s = Character.toString(c);
        System.out.println("char to String: "+s);
        //удалить все заданные символы из строки
        System.out.println("removing all chars from String: "
                +removeCharFromString("1ABCD12DW", '1'));
    }

    private static String removeCharFromString(String str, char c) {
        return str.replaceAll(Character.toString( c ), "");
    }
}
