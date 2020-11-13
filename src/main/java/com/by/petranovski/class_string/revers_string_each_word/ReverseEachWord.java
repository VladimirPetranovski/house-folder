package com.by.petranovski.class_string.revers_string_each_word;

class ReverseEachWord {
    public static void main(String[] args) {
        String str3 = "Ut sit amet consequat nisl";
        String[] words = new StringBuilder(str3).reverse().toString().split(" ");
        StringBuilder newStr = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) newStr.append(words[i]).append(" ");
        System.out.println(newStr);
    }
}
