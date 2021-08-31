package com.by.petranovski.search;

import java.util.Arrays;

public class RecursiveBinarySearch {
    public static void main(String[] args) {
        int[] array = {89, 57, 91, 47, 95, 3, 27, 22, 67, 99};
        Arrays.sort(array);
        int elementToSearch = 3;
        int firstIndex = 0;
        int lastIndex = 9;
        System.out.println(recursiveBinarySearch(array, firstIndex, lastIndex, elementToSearch));
    }

    private static int recursiveBinarySearch(int[] array, int firstIndex, int lastIndex, int elementToSearch) {
        int mid = firstIndex + (lastIndex - firstIndex) / 2;
        while (firstIndex <= lastIndex) {
            if (array[mid] == elementToSearch) {
                return mid;
            }
            if (array[mid] > elementToSearch) {
                return recursiveBinarySearch(array, firstIndex, mid - 1, elementToSearch);
            }
            return recursiveBinarySearch(array, mid + 1, lastIndex, elementToSearch);
        }
        return -1;
    }
}
