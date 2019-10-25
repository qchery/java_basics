package com.qchery.basics.algorithm.dijkstra;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 节点
 *
 * @author Chery
 * @date 2019/10/24 18:14
 */
public class Node {
    private String id;
    private Set<Edge> inEdges = new HashSet<>();
    private Set<Edge> outEdges = new HashSet<>();

    public Node(String id) {
        this.id = id;
    }

    public Integer minWeightFrom(Node fromNode) {
        return this.inEdges.stream()
                .filter(edge -> edge.getFrom() == fromNode)
                .map(Edge::getWeight).min(Integer::compareTo).orElse(0);
    }

    public List<Node> neighbors() {
        return outEdges.stream().map(Edge::getTo).collect(Collectors.toList());
    }

    public String getId() {
        return id;
    }

    public void addOutEdge(Edge edge) {
        this.outEdges.add(edge);
    }

    public void addInEdge(Edge edge) {
        this.inEdges.add(edge);
    }

    @Override
    public String toString() {
        return id;
    }
}