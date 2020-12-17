package com.kudelich.lab;

public class Main {
    public static void main(String[] args) {
        String tmp= "Разработать алгоритм и программу простого линейного поиска " +
                "с циклом For. В качестве исходных данных использовать строку " +
                "текста, из которой необходимо выделить слова. Аргумент поиска - " +
                "слово.";

        String text = "";

        for (int i = 0; i < 3999; i++) {
            text += tmp;
        }

        FindWord findWord = new FindWord();
        String[] array = new String[0];

        long start = 0;
        long end = 0;
        long res = 0;

        for (int i = 0; i < 11; i++) {
            start = System.currentTimeMillis();

            array = findWord.linearFindWords(text);

            end = System.currentTimeMillis();

            res += end - start;
            if (i==0) {
                res = 0;
            }
            System.out.println((i + 1) + ": " + (end - start));
        }

        System.out.println(res / 10);
    }
}
