package com.qchery.basics.algorithm.sort;

/**
 * Created by Chery on 2016/12/22.
 */
public interface Sorter {

    /**
     * 排序方法
     *
     * @param srcArr 原始数组
     */
    void sort(int[] srcArr);

    /**
     * 获取算法名称
     *
     * @return 算法名称
     */
    String getName();

    /**
     * 交换数据中两元素的值
     *
     * @param srcArr 原始数组
     * @param i      坐标i
     * @param j      坐标j
     */
    default void swap(int[] srcArr, int i, int j) {
        int temp = srcArr[i];
        srcArr[i] = srcArr[j];
        srcArr[j] = temp;
    }
}
