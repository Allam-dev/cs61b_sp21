package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private int size;
    private Node<T> sentinel;


    public LinkedListDeque() {
        sentinel = new Node<>(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }


    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item, sentinel.next, sentinel);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }


    public void addLast(T item) {
        Node<T> newNode = new Node<>(item, sentinel, sentinel.prev);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }


    public int size() {
        return size;
    }


    public T removeFirst() {
        T first = sentinel.next.value;
        if (size > 0) {
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size--;
        }
        return first;
    }


    public T removeLast() {
        T last = sentinel.prev.value;
        if (size > 0) {
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size--;
        }
        return last;
    }


    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        } else {
            Node<T> node = sentinel.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.value;
        }
    }


    public Iterator<T> iterator() {
        return new LinedListDequeIterator();
    }


    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel.next);
    }

    private T getRecursiveHelper(int index, Node<T> node) {
        if (index == 0) {
            return node.value;
        }
        return getRecursiveHelper(index - 1, node.next);
    }


    public void printDeque() {
        String[] items = new String[size];
        for (int i = 0; i < size(); i++) {
            items[i] = get(i).toString();
        }
        System.out.print('{' + String.join(", ", items) + '}');
    }


    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Deque) {
            Deque<T> other = (Deque<T>) obj;
            if (size != other.size()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (!(get(i).equals(other.get(i)))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private class LinedListDequeIterator implements Iterator<T> {

        int index = 0;
        Node<T> current = sentinel;


        public boolean hasNext() {
            return index < size;
        }


        public T next() {
            if (index < size) {
                current = current.next;
                index++;
                return current.value;
            }
            return null;
        }
    }
}
