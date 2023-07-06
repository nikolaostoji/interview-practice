package com.practice.interview.data_structures;

import java.util.Optional;

/**
 * Linked list implementation. This is not thread-safe.
 * @param <T>
 */
public class LinkedListImpl<T> implements LinkedList<T> {
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int size;

    public LinkedListImpl() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public LinkedListNode<T> push(final T value) {
        final LinkedListNode<T> node = new LinkedListNode<>(value);
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
            size++;
            return head;
        }
        if (size == 1) {
            node.setRightNode(head);
            tail.setLeftNode(node);
            head = node;
            size++;
            return head;
        }

        node.setRightNode(head);
        head.setLeftNode(node);
        head = node;
        size++;
        return head;
    }

    @Override
    public LinkedListNode<T> insertEnd(final T value) {
        final LinkedListNode<T> node = new LinkedListNode<>(value);
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
            size++;
            return tail;
        }

        if (size == 1) {
            node.setLeftNode(head);
            tail = node;
            head.setRightNode(node);
            size++;
            return tail;
        }

        node.setLeftNode(tail);
        tail.setRightNode(node);
        tail = node;
        size++;
        return tail;
    }

    @Override
    public LinkedListNode<T> pop() {
        if (isEmpty()) {
            return null;
        }
        if (size == 1) {
            final LinkedListNode<T> node = head;
            head = null;
            tail = null;
            size--;
            return node;
        }
        final LinkedListNode<T> currentHead = head;
        final LinkedListNode<T> currentRightNode = head.getRightNode();
        currentRightNode.setLeftNode(null);
        head = currentRightNode;
        size--;
        return currentHead;
    }

    @Override
    public LinkedListNode<T> removeLastElement() {
        if (isEmpty()) {
            return null;
        }
        if (size == 1) {
            final LinkedListNode<T> node = head;
            head = null;
            tail = null;
            size--;
            return node;
        }
        final LinkedListNode<T> currentTail = tail;
        final LinkedListNode<T> currentLeftNode = tail.getLeftNode();
        currentLeftNode.setRightNode(null);
        tail = currentLeftNode;
        size--;
        return currentTail;
    }

    @Override
    public Optional<LinkedListNode<T>> peekFront() {
        return Optional.ofNullable(head);
    }

    @Override
    public Optional<LinkedListNode<T>> peekBack() {
        return Optional.ofNullable(tail);
    }

    @Override
    public LinkedListNode<T> remove(final LinkedListNode<T> node) {
        if (isEmpty()) {
            return null;
        }
        if (node == head) {
            return pop();
        } else if (node == tail) {
            return removeLastElement();
        } else {
            final LinkedListNode<T> nodeLeft = node.getLeftNode();
            final LinkedListNode<T> nodeRight = node.getRightNode();
            nodeLeft.setRightNode(nodeRight);
            nodeRight.setLeftNode(nodeLeft);
            node.setLeftNode(null);
            node.setRightNode(null);
            size--;
            return node;
        }
    }

    @Override
    public Optional<LinkedListNode<T>> get(final T value) {
        if (isEmpty()) {
            return Optional.empty();
        }
        LinkedListNode<T> current = head;
        while (current != null) {
            if (current.getValue() == value) {
                return Optional.of(current);
            }
            current = current.getRightNode();
        }

        return Optional.empty();
    }
}
