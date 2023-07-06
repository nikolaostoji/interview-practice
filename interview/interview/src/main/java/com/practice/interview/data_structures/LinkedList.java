package com.practice.interview.data_structures;

import java.util.Optional;

/**
 * Linked list interface. Note: The runtimes are actually specific to the implementation, but I just put them in here,
 * since this is for practice, and I am only doing one implementation.
 * @param <T>
 */
public interface LinkedList<T> {

    /**
     * Evaluates if the linked list is empty
     * Runtime: O(1)
     * @return true if empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Gets the number of elements in the linked list
     * Runtime: O(1)
     * @return Number of elements
     */
    int getSize();

    /**
     * Inserts a node to the front of the linked list
     * Runtime: O(1)
     * @param value value for the node
     * @return The inserted node
     */
    LinkedListNode<T> push(final T value);

    /**
     * Inserts a node to the back of the linked list
     * Runtime: O(1)
     * @param value value for the node
     * @return The inserted node
     */
    LinkedListNode<T> insertEnd(final T value);

    /**
     * Removes a node from the front of the linked list
     * Runtime: O(1)
     * @return The deleted node, null if node was not in list
     */
    LinkedListNode<T> pop();

    /**
     * Removes a node from the end of the linked list
     * Runtime: O(1)
     * @return The deleted node, null if node was not in list
     */
    LinkedListNode<T> removeLastElement();

    /**
     * Gets the head of the linked list
     * Runtime: O(1)
     * @return The node
     */
    Optional<LinkedListNode<T>> peekFront();

    /**
     * Gets the tail of the linked list
     * Runtime: O(1)
     * @return The node
     */
    Optional<LinkedListNode<T>> peekBack();

    /**
     * Deletes the specified node
     * Runtime: O(1)
     * @param node Node to delete
     * @return Deleted node, null if node was not in the list
     */
    LinkedListNode<T> remove(final LinkedListNode<T> node);

    /**
     * Finds the specified node
     * Runtime: O(n) where n is the size of the linked list
     * @param value value of the node
     * @return The node if it exists, empty otherwise
     */
    Optional<LinkedListNode<T>> get(final T value);
}
