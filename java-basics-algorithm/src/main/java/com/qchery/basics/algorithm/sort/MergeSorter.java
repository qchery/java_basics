package com.qchery.basics.algorithm.sort;

/**
 * Created by Chery on 2017/1/8.
 */
public class MergeSorter implements Sorter {
    @Override
    public void sort(int[] srcArr) {
        System.arraycopy(
                mergeSort(srcArr, 0, srcArr.length - 1), 0,
                srcArr, 0, srcArr.length
        );
    }

    private int[] mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return new int[]{arr[left]};
        }

        int middle = (left + right) / 2;
        return mergeSortedArr(
                mergeSort(arr, left, middle),
                mergeSort(arr, middle + 1, right)
        );
    }

    private int[] mergeSortedArr(int[] arrOne, int[] arrTwo) {
        int[] result = new int[arrOne.length + arrTwo.length];
        int indexOne = 0, indexTwo = 0, indexResult = 0;

        while (indexOne < arrOne.length && indexTwo < arrTwo.length) {
            if (arrOne[indexOne] < arrTwo[indexTwo]) {
                result[indexResult++] = arrOne[indexOne++];
            } else {
                result[indexResult++] = arrTwo[indexTwo++];
            }
        }

        while (indexOne < arrOne.length) {
            result[indexResult++] = arrOne[indexOne++];
        }

        while (indexTwo < arrTwo.length) {
            result[indexResult++] = arrTwo[indexTwo++];
        }

        return result;
    }

    @Override
    public String getName() {
        return "归并";
    }
}
