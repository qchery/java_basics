package om.qchery.basics.algorithm.sort;

import com.qchery.basics.algorithm.sort.Sorter;
import com.qchery.basics.algorithm.sort.factory.SorterFactory.SortType;
import com.qchery.basics.commons.IntArrayPrinter;
import org.junit.Test;

import java.util.Random;

import static com.qchery.basics.algorithm.sort.factory.SorterFactory.getSorter;

/**
 * Created by Chery on 2016/12/22.
 */
public class SorterTest {

    private static final int ARRAY_LENGTH = 2000;

    private static int[] srcArr = new int[ARRAY_LENGTH];

    static {
        Random random = new Random();
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            srcArr[i] = random.nextInt(10000);
        }
        System.out.print("原始 : ");
        IntArrayPrinter.print(srcArr);
    }

    @Test
    public void testFastSort() {
        run(getSorter(SortType.FAST));
    }

    @Test
    public void testPomperSort() {
        run(getSorter(SortType.POMPER));
    }

    @Test
    public void testChooseSort() {
        run(getSorter(SortType.CHOOSE));
    }

    @Test
    public void testShellSort() {
        run(getSorter(SortType.SHELL));
    }

    @Test
    public void testInsertSort() {
        run(getSorter(SortType.INSERT));
    }

    @Test
    public void testMergeSort() {
        run(getSorter(SortType.MERGE));
    }

    private void run(Sorter sorter) {
        int[] clone = srcArr.clone();
        long startMillis = System.currentTimeMillis();
        sorter.sort(clone);
        long endMillis = System.currentTimeMillis();
        System.out.print(sorter.getName() + "(" + (endMillis - startMillis) + "ms)" + " : ");
        IntArrayPrinter.print(clone);
    }

}
