package com.kudelich.lab;
//array = new Sorting().acceleratedBubble(array);
public class Main {
    public static void main(String[] args) {
        long res = 0;

        for (int i = 0; i < 4; i++) {
            int[] array = new Sorting().arrayBuilder(100_000);

            long start = System.currentTimeMillis();
            int []tmp =  new Sorting().selection(array);
            long end = System.currentTimeMillis();

            res += end - start;
            System.out.println(end - start);
            if (i == 0) {
                res = 0;
            }
        }

        System.out.println(res/3);
    }
}
