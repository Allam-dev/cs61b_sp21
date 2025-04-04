package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> {
    private int size;
    private Node<T> sentinel;


    public LinkedListDeque() {
        sentinel = new Node<>(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }


    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item, sentinel.next, sentinel);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item, sentinel, sentinel.prev);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {

    }

    @Override
    public T removeFirst() {
        T first = sentinel.next.value;
        if (size > 0) {
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size--;
        }
        return first;
    }

    @Override
    public T removeLast() {
        T last = sentinel.prev.value;
        if (size > 0) {
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size--;
        }
        return last;
    }

    @Override
    public T get(int index) {
        Node<T> node = sentinel.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }



    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel.next);
    }

    private T getRecursiveHelper(int index, Node<T> node) {
        if (index == 0)
            return node.value;
        return getRecursiveHelper(index - 1, node.next);
    }


    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
