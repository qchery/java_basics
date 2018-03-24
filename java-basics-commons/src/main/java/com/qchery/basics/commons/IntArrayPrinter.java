package com.qchery.basics.commons;

/**
 * Created by Chery on 2016/12/29.
 */
public class IntArrayPrinter {

    public static void print(int[] ints) {
        int index = 0;
        for (int i : ints) {
            index++;
            if (index == 1) {
                System.out.print("[ ");
            }

            System.out.print(i + " ");

            if (index == ints.length) {
                System.out.println("]");
            }
        }
    }

}
