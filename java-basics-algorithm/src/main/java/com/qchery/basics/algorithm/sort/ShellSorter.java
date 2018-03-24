package com.qchery.basics.algorithm.sort;

/**
 * Created by Chery on 2016/12/29.
 */
public class ShellSorter implements Sorter {

    @Override
    public void sort(int[] srcArr) {

        int[] dt = new int[(int) Math.sqrt(srcArr.length)];
        int index = 0, temp = srcArr.length;
        while ((temp = temp / 2) > 0) {
            dt[index++] = temp;
        }

        for (int i : dt) {
            for (int j = i; j < srcArr.length; j++) {
                if (srcArr[j] < srcArr[j - i]) {
                    int cacheValue = srcArr[j];
                    int moveIndex = j;
                    while (moveIndex - i >= 0 && cacheValue < srcArr[moveIndex - i]) {
                        srcArr[moveIndex] = srcArr[moveIndex - i];
                        moveIndex -= i;
                    }
                    srcArr[moveIndex] = cacheValue;
                }
            }
        }
    }

    @Override
    public String getName() {
        return "希尔";
    }
}
