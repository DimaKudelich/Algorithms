package com.kudelich.main;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        int n = 1_600;
        Matrix matrix = new Matrix();
        int[][]array = matrix.createAndFillMatrix(n);

        long res = 0;
        for (int i = 0; i < 5; i++) {
            long start = System.currentTimeMillis();

            BigInteger result = matrix.findMulti(array);

            long finish = System.currentTimeMillis();

            res+= finish - start;
            System.out.println(finish - start);
        }

        System.out.println("result "+res/5);
    }
}
/*
1000 - 63260
5000 -
*/
