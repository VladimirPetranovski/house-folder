package com.by.petranovski.arrays.array_copy_to_array;

import java.util.Arrays;

class ArrayCopyArray {

    int[] array = {23, 43, 55};
    int[] copyArray = Arrays.copyOf(array, array.length);
    // если надо полностью скопировать массив

    int[] arr = {23, 43, 55, 12, 65, 88, 92};
    int[] copiedArray = Arrays.copyOfRange(arr, 1, 4);



    public static void main(String[] args) {
        ArrayCopyArray a = new ArrayCopyArray();
        System.out.println(Arrays.toString(a.copyArray));

        System.out.println(Arrays.toString(a.copiedArray));
    }
}
