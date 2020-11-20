package com.by.petranovski.patterns.pattern_latin_letters_and_numbers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CheckOnValidString {
    private CheckOnValidString() {

    }

    public static boolean check(String text) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
}
