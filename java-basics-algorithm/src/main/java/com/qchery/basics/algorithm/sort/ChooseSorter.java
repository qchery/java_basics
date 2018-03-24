package com.qchery.basics.algorithm.sort;

/**
 * Created by Chery on 2016/12/22.
 */
public class ChooseSorter implements Sorter {

    @Override
    public void sort(int[] srcArr) {
        for (int i = 0; i < srcArr.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < srcArr.length; j++) {
                if (srcArr[minIndex] > srcArr[j]) {
                    minIndex = j;
                }
            }

            swap(srcArr, i, minIndex);
        }
    }

    @Override
    public String getName() {
        return "选择";
    }
}
