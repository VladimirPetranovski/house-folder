package com.by.petranovski.loops.howfindividers;
/*
 Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
m и n вводятся с клавиатуры.
 */

import java.util.Scanner;

class HowFindDividersTwo {
    private static void dividers(int m, int n) {
        if (!isIntNumbers(m, n)) {
            System.out.println("Please enter integers more zero:");
        }
        if (!isNMinusMMoreOne(m , n)) {
            System.out.println("Please enter range more:");
        }
        findDividers(m, n);
    }

    private static boolean isIntNumbers(int m, int n) {
        return m > 0 && n > 0;
    }

    private static boolean isDividerEqualsOneOrEqualsDivider(int numbers, int m, int n) {
        return numbers != m && numbers != n;
    }

    private static boolean isNMinusMMoreOne(int m, int n) {
        return n - m > 1;
    }

    private static void findDividers(int m, int n) {
        for (int i = m; i < n; i++) {
            for (int j = 2; j < n; j++) {
                if (isDividerEqualsOneOrEqualsDivider(j, m, n) && i % j == 0) {
                    System.out.println("For " + i + " - " + j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter please number:");
        int m = scanner.nextInt();
        System.out.println("Enter please number:");
        int n = scanner.nextInt();
        dividers(m, n);
    }
}
