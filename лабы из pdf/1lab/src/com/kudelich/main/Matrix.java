package com.kudelich.main;

import java.math.BigInteger;
import java.util.Random;

public class Matrix {
    public int[][] createAndFillMatrix(int n){
        int[][]matrix = new int[n][n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = Math.abs(random.nextInt()%5);
                matrix[i][j] = tmp == 0? tmp+1 : tmp;
            }
        }

        return matrix;
    }

    public BigInteger findMulti(int[][]matrix){
        BigInteger multi = new BigInteger("1");//1

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                BigInteger tmp = new BigInteger(""+matrix[i][j]);//1 + 2 + 2
                multi = multi.multiply(tmp);//1 + 1
            }
        }

        return multi;
    }
}
