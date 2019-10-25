package com.qchery.basics.algorithm.dijkstra;

import org.junit.Test;

/**
 * Dijkstra算法单元测试
 *
 * @author Chery
 * @date 2019/10/24 18:47
 */
public class DijkstraTest {

    @Test
    public void testDijkstra() {
        Graph graph = new Graph().addNodes("A", "B", "C", "D", "E", "F", "G")
                .link("A", "B", 4)
                .link("A", "C", 10)
                .link("B", "E", 21)
                .link("C", "D", 5)
                .link("C", "F", 8)
                .link("D", "E", 5)
                .link("F", "E", 12)
                .link("E", "G", 4)
                .tag("A", "G");
        System.out.println(Dijkstra.dijkstra(graph));
    }

}