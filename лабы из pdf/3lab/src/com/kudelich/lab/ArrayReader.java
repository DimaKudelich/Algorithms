package com.kudelich.lab;

import java.util.Random;
import java.util.RandomAccess;

public class ArrayReader {
    public int[] arrayFromString(String text) {
        String[] numbers = text.trim().split(" ");

        int[] array = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            array[i] = Integer.parseInt(numbers[i]);
        }

        return array;
    }

    public int[] arrayBuilding(int size){
        int[]res = new int[size];

        for (int i = 0; i < size; i++) {
            res[i] = new Random().nextInt();
        }

        return res;
    }
}
