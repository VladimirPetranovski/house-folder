package com.by.petranovski.sort_array;

import java.util.Arrays;

public class ChoiceSort {

    public static void main(String[] args) {
        int[] array = {10, -2, 0, 9, 1, 7};
        System.out.println(Arrays.toString(sortArrayChoice(array)));
    }

    private static int[] sortArrayChoice(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int pos = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    pos = j;
                    min = array[j];

                }
            }
            array[pos] = array[i];
                array[i] = min;
        }
        return array;
    }
}
