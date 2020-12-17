package com.kudelich.lab;

import java.util.Arrays;

public class FindWord {
    public String[] linearFindWords(String text) {
        String[] words = new String[0];//1

        int startWord = 0;//1
        int endWord = 0;//1

        for (int i = 0; i < text.length(); i++) {//1 + 3*n + 3*x
            if (!isCharDelimiter(text.charAt(i))) {//1 + 35 + 2
                endWord += 1;//1+1
            } else {
                if (startWord != endWord) {//1
                    words = Arrays.copyOf(words, words.length + 1);//1
                    words[words.length - 1] = text.substring(startWord, endWord);//2 + 1
                }
                startWord = i + 1;//1+1
                endWord = i + 1;//1+1
            }
        }
        return words;
    }

    public boolean isCharDelimiter(char letter) {
        char[] delimiters = {' ', ',', '.', ':', ';', '!', '?', '-'};//1

        for (int i = 0; i < delimiters.length; i++) {//1+3*8+3*x
            if (letter == delimiters[i]) {//1+2
                return true;
            }
        }
        return false;
    }
}
