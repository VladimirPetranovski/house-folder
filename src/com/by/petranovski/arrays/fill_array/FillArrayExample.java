package com.by.petranovski.arrays.fill_array;

import java.util.Arrays;

class FillArrayExample {
    public static void main(String[] args) {
        int[] in = {1, -1, 2, -9, 10, -5};
        int[] arr = new int[6];

        int indexValue = 0; // так можно заполнить массив из другого массива с соблюдением какого то условия
        for (int i : in) {
            if (i >= -4 && i <= 10) {
                arr[indexValue] = i;
                indexValue++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
