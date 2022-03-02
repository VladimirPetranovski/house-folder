package com.by.petranovski.sort_array;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {10, -2, 0, 9, 1, 7};
        System.out.println(Arrays.toString(sortArrayBubble(array)));
    }

    private static int[] sortArrayBubble(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
