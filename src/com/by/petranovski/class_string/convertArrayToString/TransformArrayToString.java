package com.by.petranovski.class_string.convertArrayToString;

class TransformArrayToString {
    String convertArrayToString(String[] array, String text) {
        String str = new String();
        for (String s : array) {
            str += s;
        }
        return str;
    }
}
