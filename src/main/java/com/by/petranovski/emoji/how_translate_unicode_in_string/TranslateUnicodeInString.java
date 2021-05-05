package com.by.petranovski.emoji.how_translate_unicode_in_string;

public class TranslateUnicodeInString {

    // вот unicode emoji https://unicode.org/emoji/charts/full-emoji-list.html
    // U+1F602 - это кодовая точка Unicode, и Java может их читать.
    public void emojiString(Integer unicodeEmoji) {
        // U+1F602 = 0x1F602
//        System.out.println(new StringBuilder().appendCodePoint(0x1F602).toString());
        for(char c : new StringBuilder().appendCodePoint(unicodeEmoji).toString().toCharArray()) {
            System.out.print("\\u" + String.valueOf(Integer.toHexString(c)));
        }
    }

    public static void main(String[] args) {
        new TranslateUnicodeInString().emojiString(0x1F602);
    }
}


