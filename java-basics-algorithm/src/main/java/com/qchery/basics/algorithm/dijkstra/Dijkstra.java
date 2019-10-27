package com.qchery.basics.algorithm.dijkstra;

import java.util.*;

/**
 * Dijkstra算法
 *
 * @author Chery
 * @date 2019/10/24 18:14
 */
public class Dijkstra {

    public static DijkstraResult dijkstra(Graph graph) {
        // 除初始节点外的所有节点的成本默认为无穷大
        Map<Node, Integer> costMap = new HashMap<>(graph.getNodes().size() - 1);
        for (Node node : graph.getNodes()) {
            if (node == graph.getStartNode()) {
                costMap.put(node, null);
            }
        }

        // 保留每个节点当前最小路径的前一个节点
        Map<Node, Node> previousMap = new HashMap<>(graph.getNodes().size() - 1);
        // 记录所有已经完成扩展操作的节点（每个节点只经过一次扩展操作）
        Set<Node> doneNodes = new HashSet<>();

        Node fromNode = graph.getStartNode();
        while (fromNode != null) {
            List<Node> toNodes = fromNode.neighbors();
            // 遍历所有to节点，更新每个to节点的最小权重和
            for (Node toNode : toNodes) {
                // 查找from节点与to节点之间的最小权重（假想from到to有多条边的情况）
                Integer weight = toNode.minWeightFrom(fromNode);
                // 计算经由from节点时，to节点的最小权重和
                Integer fromWeight = Optional.ofNullable(costMap.get(fromNode))
                        .map(i -> i + weight).orElse(weight);
                // 比较to节点之前的权重和与经由from节点的权重和，取小，并更新相关路由信息
                Integer toWeight = costMap.get(toNode);
                Integer minWeight = toWeight;
                if (toWeight != null) {
                    if (toWeight > fromWeight) {
                        minWeight = fromWeight;
                        previousMap.put(toNode, fromNode);
                    }
                } else {
                    minWeight = fromWeight;
                    previousMap.put(toNode, fromNode);
                }
                costMap.put(toNode, minWeight);
            }

            doneNodes.add(fromNode);
            // 查找权重和最小的节点，需排除掉已经经历过扩展的节点
            fromNode = costMap.entrySet().stream()
                    .filter(nodeEntry -> !doneNodes.contains(nodeEntry.getKey()))
                    .sorted(Comparator.comparing(Map.Entry::getValue))
                    .map(Map.Entry::getKey).findFirst().orElse(null);
        }

        // 拼接最短路径
        List<Node> route = new LinkedList<>();
        Node printNode = graph.getEndNode();
        while (printNode != null) {
            route.add(0, printNode);
            printNode = previousMap.get(printNode);
        }
        return new DijkstraResult(route, costMap.get(graph.getEndNode()));
    }

}
