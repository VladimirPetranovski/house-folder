package com.by.petranovski.class_string.transform_string_to_array_words;

import java.util.Arrays;

class TransformStringToArrayWords {
    String text;
    static String[] divideStringByArrayWordsWithoutPunctuationMarksAndBlanks(String text) {
        String[] words = text.toLowerCase().split("[\\p{Punct}\\s]+");
        return words;
    } //этот метод преобразует текст в массив слов без знаков препинания и пробелов, переводит его в нижний регистр букв
      //toUpperCase в верхний
    public static void main(String[] args) {
        System.out.println(Arrays.toString(divideStringByArrayWordsWithoutPunctuationMarksAndBlanks("Mama mila ramu")));
        for (String strings : divideStringByArrayWordsWithoutPunctuationMarksAndBlanks("Mama! mila, ramu.")) {
            System.out.println(strings);
        }
    }
}
