package com.by.petranovski.class_string.palindrome;

class Palindrome {
    boolean isPalindrome(String text) {
        if (text == null) {
            return false;
        }
        /*StringBuilder stringBuilder = new StringBuilder(text);  // первый способ
        stringBuilder.reverse();
        return stringBuilder.toString().equals(text);*/
        //int length = text.length();
        for (int i = 0; i < text.length() / 2; i++) {
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) { // второй способ
                return false;
            }
        }
        return true;
    }
}
