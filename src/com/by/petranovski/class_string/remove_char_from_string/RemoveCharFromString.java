package com.by.petranovski.class_string.remove_char_from_string;

class RemoveCharFromString {
    private static String removeChar(String str, char ch) {
        if (str == null) {
            return null;
        }
        return str.replaceAll(Character.toString(ch), ""); // replacement-замена на что то
    }

    public static void main(String[] args) {
        System.out.println(removeChar("abababaaba", 'a'));
    }
}
