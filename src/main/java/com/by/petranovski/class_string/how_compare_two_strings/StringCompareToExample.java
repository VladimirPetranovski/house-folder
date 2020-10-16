package com.by.petranovski.class_string.how_compare_two_strings;
/*
Класс String наследует интерфейс Comparable и имеет два варианта метода compareTo().

Метод compareTo(String anotherString) сравнивает объект String с полученным аргументом String лексикографически.
Если текущая строка предшествует полученной строке, метод возвращает отрицательное значение типа integer,
 и если строка следует за полученным аргументом, то возвращает положительное значение integer.
 Если метод возвращает 0, значит строка имеет то же значение, в таком случае метод equals(String str) так же вернет true.

compareToIgnoreCase(String str): этот метод подобен предыдущему, за исключением того, что он игнорирует регистр символов.
Он использует CASE_INSENSITIVE_ORDER Comparator для регистронезависимого сравнения.
Если возвращаемое значение равно нулю, тогда метод equalsIgnoreCase(String str) так же вернет true.
 */

class StringCompareToExample {
    public static void main(String[] args) {
        String str = "DEF";
        System.out.println(str.compareTo("ABC"));
        System.out.println(str.compareTo("DEF"));
        System.out.println(str.compareTo("GHI"));
        System.out.println(str.compareToIgnoreCase("def"));
        System.out.println(str.equals("DEF"));
        System.out.println(str.equalsIgnoreCase("def"));
    }
}
