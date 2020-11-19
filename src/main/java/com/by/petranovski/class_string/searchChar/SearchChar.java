package com.by.petranovski.class_string.searchChar;

import java.util.ArrayList;
import java.util.Arrays;

class SearchChar {
    public static void main(String[] args) {
        String str = "habr";
        char search = 'h';
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == search) {
                System.out.println(search);
            }
        }
        System.out.println(str.indexOf(search) != -1);

        // обьединение строк с помощью метода join
        String str2 = "rrr";
        String str3 = "www";
        String delimiter = ", ";
        System.out.println(String.join(delimiter, str2, str3));
        // или так
        System.out.println(String.join(". ", new ArrayList<CharSequence>(Arrays.asList(str2, str3))));

    }

}
