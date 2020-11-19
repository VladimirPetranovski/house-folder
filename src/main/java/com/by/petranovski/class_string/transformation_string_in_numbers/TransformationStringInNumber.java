package com.by.petranovski.class_string.transformation_string_in_numbers;

class TransformationStringInNumber {
    public static void main(String[] args) {
        String str = "10";
        int first = Integer.parseInt(str);
        int second = Integer.valueOf(str);
        System.out.println(first);
        System.out.println(second);
    }
}
