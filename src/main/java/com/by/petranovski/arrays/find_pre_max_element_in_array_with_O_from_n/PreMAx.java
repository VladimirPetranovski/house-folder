package com.by.petranovski.arrays.find_pre_max_element_in_array_with_O_from_n;

public class PreMAx {
    public static void main(String[] args) {
        int[] arr = {-1, 9, 5, -2, 8};
        System.out.println(findPreMax(arr));
    }

    private static int findPreMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int preMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                preMax = max;
                max = arr[i];
            } else if (preMax < arr[i] && max != arr[i]) {
                preMax = arr[i];
            } else return -1; // если массив состоит из одинаковых чисел
        }
        return preMax;
    }
}
