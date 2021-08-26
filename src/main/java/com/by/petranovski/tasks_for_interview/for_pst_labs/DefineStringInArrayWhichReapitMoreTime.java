package com.by.petranovski.tasks_for_interview.for_pst_labs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class DefineStringInArrayWhichRepeatMoreTime {

    public static final Logger logger = LoggerFactory.getLogger(DefineStringInArrayWhichRepeatMoreTime.class);

    public static void main(String[] args) {
        String[] array = {"Вася идет", "Вова едет домой", "Федя плавает в пруду", "Вася идет", "Вова едет домой",
                "Вова едет домой", "Федя плавает в пруду", "Федя плавает в пруду", "Федя плавает в пруду"};
        String stringWhichRepeatMostOfAll = findStringWhichRepeatMostOfAll(array);
        int amountWordsInString = findAmountWordsInString(stringWhichRepeatMostOfAll);
        logger.info("Строка, которая встречается чаще всего --- {}", stringWhichRepeatMostOfAll);
        logger.info("Количество слов в данной строке --- {}", amountWordsInString);

    }

    private static int[] defineArrayRepeatingString(String[] array) {
        int[] countArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            for (String s : array) {
                if (array[i].equals(s)) {
                    countArray[i] += 1;
                }
            }
        }
        return countArray;
    }

    private static int findIndexMaxByValue(int[] array) {
        int maxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    private static String findStringWhichRepeatMostOfAll(String[] array) {
        int[] arrayInt = defineArrayRepeatingString(array);
        int maxIndex = findIndexMaxByValue(arrayInt);
        return array[maxIndex];
    }
    private static int findAmountWordsInString(String str) {
        String[] arrayString = str.trim().split(" ");
        return arrayString.length;
    }
}
