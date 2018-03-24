package com.qchery.basics.data.struct;

import com.qchery.basics.commons.IntArrayPrinter;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Chery
 * @date 2018/3/24 17:07
 */
public class AvtNodeTest {

    private int[] arr = new int[]{3, 2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9};

    @Test
    public void testAvt() {
        AvtNode<Integer> root = new AvtNode<>(arr[0], null, null);
        for (int i = 1; i < arr.length; i++) {
            root = root.insert(arr[i], root);
            ArrayList<Integer> container = new ArrayList<>();
            root.preOutput(root, container);

            int[] output = new int[container.size()];
            for (int j = 0; j < container.size(); j++) {
                output[j] = container.get(j);
            }

            IntArrayPrinter.print(output);
        }

    }

}