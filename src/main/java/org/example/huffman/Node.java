package org.example.huffman;

public class Node implements Comparable<Node> {
    private Character value;
    private Node left;
    private Node right;
    private int count = 0;
    private NodeType type = NodeType.VALUE_TYPE;

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public NodeType getType() {
        return type;
    }

    public void setType(NodeType type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "\nNode{" +
                (value == null ? "" : "value=" + value + ", ") +
                "count=" + count +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.count - o.count;
    }
}