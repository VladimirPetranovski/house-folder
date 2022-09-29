package com.by.petranovski.search;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {89, 57, 91, 47, 95, 3, 27, 22, 67, 99};
        Arrays.sort(array);
        int elementToSearch = 95;
        System.out.println(binarySearch(array, elementToSearch));

        InThread thread = new InThread();
        thread.run();
    }

    private static int binarySearch(int[] array, int elementToSearch) {
        int firstElement = 0;
        int lastElement = array.length - 1;
        while (firstElement <= lastElement) {
            int middle = (firstElement + lastElement) / 2;
            if (array[middle] == elementToSearch) {
                return middle;
            } else if(array[middle] < elementToSearch) {
                firstElement = middle + 1;
            } else if(array[middle] > elementToSearch) {
                lastElement = middle - 1;
            }
        }
        return -1;
    }
}
