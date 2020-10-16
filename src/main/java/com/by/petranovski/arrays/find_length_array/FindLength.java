package com.by.petranovski.arrays.find_length_array;

import java.util.Arrays;

class FindLength {

    static int findLengthFinishArray(int[] in, int numberFrom, int numberTo) { //как найти длину второго массива из
        // первого с соблюдением условий
        int count = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] >= numberFrom && in[i] <= numberTo) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] in = {4, 1, 5, 7, -1};
        int[] arr = new int[findLengthFinishArray(in, 1, 7)];
        System.out.println(arr.length);
    }
}
