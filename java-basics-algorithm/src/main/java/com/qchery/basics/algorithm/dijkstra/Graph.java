package com.qchery.basics.algorithm.dijkstra;

import java.util.HashSet;
import java.util.Set;

/**
 * 图
 *
 * @author Chery
 * @date 2019/10/24 18:14
 */
public class Graph {

    private Node startNode;
    private Node endNode;
    private Set<Node> nodes = new HashSet<>();

    public Graph addNodes(String... ids) {
        if (ids != null) {
            for (String id : ids) {
                nodes.add(new Node(id));
            }
        }
        return this;
    }

    public Graph tag(String startId, String endId) {
        this.startNode = findNode(startId);
        this.endNode = findNode(endId);
        return this;
    }

    public Graph link(String fromNodeId, String toNodeId, int weight) {
        Node fromNode = findNode(fromNodeId);
        Node toNode = findNode(toNodeId);
        Edge edge = new Edge(fromNode, toNode, weight);
        fromNode.addOutEdge(edge);
        toNode.addInEdge(edge);
        return this;
    }

    public Node findNode(String nodeId) {
        for (Node node : nodes) {
            if (node.getId().equals(nodeId)) {
                return node;
            }
        }
        return null;
    }

    public Node getStartNode() {
        return startNode;
    }

    public Node getEndNode() {
        return endNode;
    }

    public Set<Node> getNodes() {
        return nodes;
    }
}