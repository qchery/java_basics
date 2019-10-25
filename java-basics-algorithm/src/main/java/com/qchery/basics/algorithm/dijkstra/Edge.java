package com.qchery.basics.algorithm.dijkstra;

/**
 * 加权边
 *
 * @author Chery
 * @date 2019/10/24 18:14
 */
public class Edge {
    private Node from;
    private Node to;
    private int weight;

    public Edge(Node fromNode, Node toNode, int weight) {
        this.from = fromNode;
        this.to = toNode;
        this.weight = weight;
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }
}