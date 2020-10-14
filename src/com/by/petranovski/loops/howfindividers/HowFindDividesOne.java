package com.by.petranovski.loops.howfindividers;
 /*
 Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
m и n вводятся с клавиатуры.
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HowFindDividesOne {
    public static void main(String[] args) throws IOException {

        task();
    }

    private static void task() throws IOException {

        int m;
        int n;
        boolean print;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите числа m и n ");

        m = Integer.parseInt(reader.readLine());
        n = Integer.parseInt(reader.readLine());

        for (int i = m; i <= n; i++) {

            print = true;

            System.out.print(i + " - ");

            for (int j = i - 1; j > 1; j--) {

                if (i % j == 0) {

                    print = false;
                    System.out.print(j);
                    System.out.print(j != 2 ? ", " : ".");
                }
            }

            System.out.println(print ? "нет делителей" : "");
        }
    }

}
