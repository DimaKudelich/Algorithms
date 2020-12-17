package com.kudelich.lab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FindNumber fn = new FindNumber();
        ArrayReader ar = new ArrayReader();
        int[] numbers = ar.arrayBuilding(8_500);
//
//        int key = new Scanner(System.in).nextInt();

        long res = 0;
        for (int i = 0; i < 3; i++) {
            long start = System.nanoTime();
            fn.recursionFindingNumber(numbers, 1, 0);
            long end = System.nanoTime();

            res += end - start;

            if (i == 0){
                res = 0;
            }

            System.out.println((i + 1) + " : " + (end - start));
        }

        System.out.println(res / 2);
    }
}
