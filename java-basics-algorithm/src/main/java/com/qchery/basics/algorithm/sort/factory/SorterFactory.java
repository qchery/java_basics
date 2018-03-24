package com.qchery.basics.algorithm.sort.factory;

import com.qchery.basics.algorithm.sort.*;

/**
 * Created by Chery on 2016/12/22.
 */
public class SorterFactory {

    /**
     * 获取排序器
     *
     * @param sortType 算法类型
     * @return 排序器
     */
    public static Sorter getSorter(SortType sortType) {
        switch (sortType) {
            case CHOOSE:
                return new ChooseSorter();
            case FAST:
                return new FastSorter();
            case POMPER:
                return new PomperSorter();
            case SHELL:
                return new ShellSorter();
            case INSERT:
                return new InsertSorter();
            case MERGE:
                return new MergeSorter();
        }
        return new FastSorter();
    }

    public enum SortType {
        FAST, CHOOSE, SHELL, POMPER, INSERT, MERGE
    }

}
