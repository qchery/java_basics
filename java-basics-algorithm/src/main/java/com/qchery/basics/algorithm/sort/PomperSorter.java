package com.qchery.basics.algorithm.sort;

/**
 * Created by Chery on 2016/12/22.
 */
public class PomperSorter implements Sorter {
    @Override
    public void sort(int[] srcArr) {
        for (int i = 0; i < srcArr.length - 1; i++) {
            for (int j = 0; j < srcArr.length - i - 1; j++) {
                if (srcArr[j] > srcArr[j + 1]) {
                    swap(srcArr, j, j + 1);
                }
            }
        }
    }

    @Override
    public String getName() {
        return "冒泡";
    }
}
