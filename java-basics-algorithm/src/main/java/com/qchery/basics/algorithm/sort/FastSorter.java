package com.qchery.basics.algorithm.sort;

/**
 * Created by Chery on 2016/12/21.
 */
public class FastSorter implements Sorter {

    @Override
    public void sort(int[] srcArr) {
        fastSort(srcArr, 0, srcArr.length - 1);
    }

    private void fastSort(int[] srcArr, int left, int right) {
        if (left < right) {
            int lot = srcArr[left];
            int i = left, j = right;

            while (i < j) {
                while (i < j && lot < srcArr[j]) {
                    j--;
                }
                if (i < j) {
                    srcArr[i++] = srcArr[j];
                }
                while (i < j && lot > srcArr[i]) {
                    i++;
                }
                if (i < j) {
                    srcArr[j--] = srcArr[i];
                }
            }

            srcArr[i] = lot;
            fastSort(srcArr, left, i - 1);
            fastSort(srcArr, i + 1, right);
        }
    }

    @Override
    public String getName() {
        return "快速";
    }
}
