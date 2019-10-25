package com.qchery.basics.algorithm.dijkstra;

import java.util.List;

/**
 * Dijkstra算法的执行结果
 * 包含最短路径与最短的权重和
 *
 * @author Chery
 * @date 2019/10/24 18:14
 */
public class DijkstraResult {
    private List<Node> route;
    private int minWeight;

    public DijkstraResult(List<Node> route, int minWeight) {
        this.route = route;
        this.minWeight = minWeight;
    }

    @Override
    public String toString() {
        return route + " : " + minWeight;
    }
}