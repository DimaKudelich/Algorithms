package com.kudelich.lab;

import java.util.Random;

public class Sorting {
    public int[] acceleratedBubble(int []array) {
        int k = 0;
        boolean flag = true;

        while (flag) {
            flag = false;

            for (int i = 0; i < (array.length - k - 1); i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    flag = true;
                }
            }

            k += 1;
        }

        return array;
    }

    public int[] selection(int []array) {
        for (int k = 0; k < array.length; k++) {
            int j = k;

            for (int i = k + 1; i < array.length; i++) {
                if (array[i] < array[j]) {
                    j = i;
                }
            }

            if (k != j) {
                int tmp = array[k];
                array[k] = array[j];
                array[j] = tmp;
            }
        }

        return array;
    }

    public int[] arrayBuilder(int size){
        int[]array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(500);
        }

        return array;
    }
}
