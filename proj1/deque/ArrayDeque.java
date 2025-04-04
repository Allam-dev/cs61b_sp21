package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {
    private int size;
    private T[] arr;
    private int firstIndex;
    private int lastIndex;

    public ArrayDeque() {
        arr = (T[]) new Object[8];
        size = 0;
        firstIndex = 0;
        lastIndex = 0;
    }

    @Override
    public void addFirst(T item) {
        extendArray();
        if (arr[firstIndex] != null) {
            firstIndex = prevOf(firstIndex);
        }
        arr[firstIndex] = item;
        size++;
    }

    @Override
    public void addLast(T item) {
        extendArray();
        if (arr[lastIndex] != null) {
            lastIndex = nextOf(lastIndex);
        }
        arr[lastIndex] = item;
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
        T first = arr[firstIndex];
        if (first != null) {
            arr[firstIndex] = null;
            firstIndex = nextOf(firstIndex);
            size--;
            shrinkArray();
        }
        return first;
    }

    @Override
    public T removeLast() {
        T last = arr[lastIndex];
        if (last != null) {
            arr[lastIndex] = null;
            lastIndex = prevOf(lastIndex);
            size--;
            shrinkArray();
        }
        return last;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            return null;
        else
            return arr[index];
    }


    private int nextOf(int index) {
        if (index == arr.length - 1)
            return 0;
        return index + 1;
    }

    private int prevOf(int index) {
        if (index == 0)
            return arr.length - 1;
        return index - 1;
    }


    private void extendArray() {
        if (arr.length == size) {
            T[] newArr = (T[]) new Object[size * 2];
            boolean moveToNext = prevOf(firstIndex) == lastIndex;
            for (int i = 0; i < size; i++) {
                newArr[i] = arr[firstIndex];
                if (moveToNext)
                    firstIndex = nextOf(firstIndex);
                else
                    firstIndex = prevOf(firstIndex);
            }
            arr = newArr;
            firstIndex = 0;
            lastIndex = size - 1;
        }
    }

    private void shrinkArray() {
        if (size > 16 && arr.length / size >= 4) {
            T[] newArr = (T[]) new Object[arr.length / 4];
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = arr[firstIndex];
                firstIndex = nextOf(firstIndex);
            }
            arr = newArr;
            firstIndex = 0;
            lastIndex = size - 1;
        }
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);
        deque.addLast(8);
        deque.addLast(9);
        deque.addLast(10);
        deque.addLast(11);
        deque.addLast(12);
        deque.removeFirst();
        deque.removeLast();
        deque.removeLast();
        deque.removeFirst();
    }
}
