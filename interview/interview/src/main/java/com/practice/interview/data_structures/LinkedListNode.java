package com.practice.interview.data_structures;

public class LinkedListNode<T> {

    private final T value;
    private LinkedListNode<T> left;
    private LinkedListNode<T> right;

    public LinkedListNode(final T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public T getValue() {
        return value;
    }

    public LinkedListNode<T> getLeftNode() {
        return left;
    }

    public LinkedListNode<T> getRightNode() {
        return right;
    }

    public void setLeftNode(final LinkedListNode<T> node) {
        left = node;
    }

    public void setRightNode(final LinkedListNode<T> node) {
        right = node;
    }
}
