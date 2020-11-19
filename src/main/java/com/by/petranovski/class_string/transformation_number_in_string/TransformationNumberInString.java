package com.by.petranovski.class_string.transformation_number_in_string;

class TransformationNumberInString {
    public static void main(String[] args) {
        int a = 10;
        String str = String.valueOf(a);
        String str1 = a + "";
        String str2 = Integer.toString(a);
        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
    }
}
