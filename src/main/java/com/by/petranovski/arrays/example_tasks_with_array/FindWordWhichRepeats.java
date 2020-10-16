package com.by.petranovski.arrays.example_tasks_with_array;

class FindWordWhichRepeats { // так можно найти слово в тексте, кот повторяется больше всего раз
    public String findMostFrequentWord(String text) {
        String[] textArray;
        int[] wordCountArray;
        textArray = convertStringToWordArray(text);
        wordCountArray = new int[textArray.length];

        int wordCounter = 0;
        for (int wordCount = 0; wordCount < textArray.length; wordCount++) {
            for (String s : textArray) {
                if (textArray[wordCount].equals(s)) {
                    wordCounter++;
                }
            }
            wordCountArray[wordCount] = wordCounter;
            wordCounter = 0;
        }

        int max = 0;
        for (int count = 0; count < wordCountArray.length; count++) {
            if (wordCountArray[count] > max) {
                max = count;
            }
        }
        return textArray[max];
    }

    private String[] convertStringToWordArray(String text) {
        return text.split(" ");
    }

    public static void main(String[] args) {
        FindWordWhichRepeats wordService = new FindWordWhichRepeats();
        String result = wordService.findMostFrequentWord("Это текст просто текст просто просто");
        System.out.println(result);
    }
}
