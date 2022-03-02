package com.by.petranovski.sort_array;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] array = {10, -2, 0, 9, 1, 7};
        System.out.println(Arrays.toString(sortArrayInsert(array)));
    }

    private static int[] sortArrayInsert(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
        return array;
    }
}
