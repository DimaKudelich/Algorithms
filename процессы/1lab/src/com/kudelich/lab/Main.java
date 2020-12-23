package com.kudelich.lab;

public class Main {
    public static int findCriticalWay(int[][]matrix) {
        int i = 0, j = 0;
        int critical = matrix[i][j];
        System.out.print(matrix[i][j]+";");
        int tmp = 0;

        while (i != matrix.length - 1 || j != matrix.length - 1) {
            if (j == matrix.length-1){
                i++;
                tmp=matrix[i][j];
            }else if(i == matrix.length-1){
                j++;
                tmp=matrix[i][j];
            } else{
                if (matrix[i + 1][j] > matrix[i][j + 1]) {
                    tmp= matrix[i + 1][j];
                    i+=1;
                } else {
                    tmp= matrix[i][j + 1];
                    j+=1;
                }
            }

            System.out.print(tmp+";");
            critical+=tmp;
        }

        System.out.println();
        return critical;
    }

    public static void main(String[] args) {
        int [][] matrix = {
                {1,3,4,5,3,2,1},
                {3,4,5,3,2,1,1},
                {4,5,3,2,1,1,3},
                {5,3,2,1,1,3,4},
                {3,2,1,1,3,4,5},
                {2,1,1,3,4,5,3},
                {1,1,3,4,5,3,2}
        };

        System.out.println(Main.findCriticalWay(matrix));
    }
}
