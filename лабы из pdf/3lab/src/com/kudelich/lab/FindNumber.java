package com.kudelich.lab;

public class FindNumber {
    public int recursionFindingNumber(int[] array, int key, int index) {
        if (index >= array.length) {
            System.out.println("Нет такого ключа в массиве");
            return -1;
        }

        if (array[index] != key) {
            index = recursionFindingNumber(array, key, index + 1);
        } else {
            return index;
        }

        return index;
    }
}
