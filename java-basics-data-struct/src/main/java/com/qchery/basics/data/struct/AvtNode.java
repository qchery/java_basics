package com.qchery.basics.data.struct;

import java.util.List;

/**
 * 平衡二叉树
 *
 * @author Chery
 * @date 2017/1/8.
 */
public class AvtNode<T extends Comparable<T>> {

    private static final int ALLOWED_IMBALANCE = 1;

    private T value;
    private AvtNode<T> left;
    private AvtNode<T> right;
    private int length;

    public AvtNode(T value, AvtNode<T> left, AvtNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public AvtNode<T> insert(T nodeValue, AvtNode<T> avtNode) {
        if (avtNode == null) {
            return new AvtNode<>(nodeValue, null, null);
        }
        int compareTo = nodeValue.compareTo(avtNode.value);
        if (compareTo < 0) {
            avtNode.left = insert(nodeValue, avtNode.left);
        } else if (compareTo > 0) {
            avtNode.right = insert(nodeValue, avtNode.right);
        } else {
            // do nothing
        }

        return balance(avtNode);
    }

    public int length(AvtNode<T> avtNode) {
        return avtNode == null ? -1 : avtNode.length;
    }

    /**
     * 调整树的高度，使之为一个平衡二叉树
     *
     * @param avtNode 未经调整的树
     * @return 调整过后的树
     */
    private AvtNode<T> balance(AvtNode<T> avtNode) {
        if (avtNode == null) {
            return null;
        }

        AvtNode<T> leftNode = avtNode.left;
        AvtNode<T> rightNode = avtNode.right;
        if (length(leftNode) - length(rightNode) > ALLOWED_IMBALANCE) {
            if (length(leftNode.left) >= length(leftNode.right)) {
                avtNode = rotateWithLeftChild(avtNode);
            } else {
                avtNode = doubleWithLeftChild(avtNode);
            }
        } else if (length(rightNode) - length(leftNode) > ALLOWED_IMBALANCE) {
            if (length(rightNode.right) >= length(rightNode.left)) {
                avtNode = rotateWithRightChild(avtNode);
            } else {
                avtNode = doubleWithRightChild(avtNode);
            }
        }

        avtNode.length = Math.max(length(leftNode), length(rightNode)) + 1;
        return avtNode;
    }

    private AvtNode<T> doubleWithRightChild(AvtNode<T> avtNode) {
        avtNode.right = rotateWithLeftChild(avtNode.right);
        return rotateWithRightChild(avtNode);
    }

    private AvtNode<T> rotateWithRightChild(AvtNode<T> avtNode) {
        AvtNode<T> rootNode = avtNode.right;
        avtNode.right = rootNode.left;
        rootNode.left = avtNode;
        avtNode.length = Math.max(length(avtNode.left), length(avtNode.right)) + 1;
        rootNode.length = Math.max(length(rootNode.left), length(rootNode.right)) + 1;
        return rootNode;
    }

    private AvtNode<T> doubleWithLeftChild(AvtNode<T> avtNode) {
        avtNode.left = rotateWithRightChild(avtNode.left);
        return rotateWithLeftChild(avtNode);
    }

    private AvtNode<T> rotateWithLeftChild(AvtNode<T> avtNode) {
        AvtNode<T> rootNode = avtNode.left;
        avtNode.left = rootNode.right;
        rootNode.right = avtNode;
        avtNode.length = Math.max(length(avtNode.left), length(avtNode.right)) + 1;
        rootNode.length = Math.max(length(rootNode.left), length(rootNode.right)) + 1;
        return rootNode;
    }

    /**
     * 中序输出
     *
     * @param avtNode   根节点
     * @param container 容器
     */
    public void preOutput(AvtNode<T> avtNode, List<T> container) {
        container.add(avtNode.value);
        if (avtNode.left != null) {
            preOutput(avtNode.left, container);
        }
        if (avtNode.right != null) {
            preOutput(avtNode.right, container);
        }
    }
}
