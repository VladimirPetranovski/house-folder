package com.by.petranovski.class_string.palindrome;
/*
проверить, я вляется ли строка полиндромом, игнорируя знаки препинания и пробелы
 */

class Palindrome {
    boolean isPalindrome(String text) {
        if (text == null) {
            return false;
        }
        String str = convertArrayToString(divideStringByArrayWordsWithoutPunctuationMarksAndBlanks(text), text);
        /*StringBuilder stringBuilder = new StringBuilder(str);  // первый способ
        stringBuilder.reverse();
        return stringBuilder.toString().equals(str);*/
        //int length = str.length();
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) { // второй способ
                return false;
            }
        }
        return true;
    }

    String[] divideStringByArrayWordsWithoutPunctuationMarksAndBlanks(String text) {  //перевожу строку, в массив слов, уберая при этом все знаки препинания  и пробелы
        String[] words = text.toLowerCase().split("[\\p{Punct}\\s]+");
        return words;
    }

    String convertArrayToString(String[] array, String text) { //перевожу массив слов в строку
        String str = new String();
        for (String s : divideStringByArrayWordsWithoutPunctuationMarksAndBlanks(text)) {
            str += s;
        }
        return str;
    }
}
