package com.qchery.basics.algorithm.sort;

/**
 * Created by Chery on 2017/1/8.
 */
public class InsertSorter implements Sorter {

    @Override
    public void sort(int[] srcArr) {
        int j;
        for (int i = 0; i < srcArr.length - 1; i++) {
            int insertValue = srcArr[i + 1];
            j = i;
            while (j >= 0 && insertValue < srcArr[j]) {
                srcArr[j + 1] = srcArr[j];
                j--;
            }
            srcArr[j + 1] = insertValue;
        }
    }

    @Override
    public String getName() {
        return "插入";
    }
}
