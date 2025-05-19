package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
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


    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof ArrayDeque) {
            ArrayDeque<T> other = (ArrayDeque<T>) o;
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

    public void printDeque() {
        String[] items = new String[size];
        for (int i = 0; i < size(); i++) {
            items[i] = get(i).toString();
        }
        System.out.print('{' + String.join(", ", items) + '}');
    }

    public void addFirst(T item) {
        extendArray();
        if (arr[firstIndex] != null) {
            firstIndex = prevOf(firstIndex);
        }
        arr[firstIndex] = item;
        size++;
    }

    public void addLast(T item) {
        extendArray();
        if (arr[lastIndex] != null) {
            lastIndex = nextOf(lastIndex);
        }
        arr[lastIndex] = item;
        size++;
    }

    public int size() {
        return size;
    }


    public T removeFirst() {
        T first = arr[firstIndex];
        if (first != null) {
            arr[firstIndex] = null;
            size--;
            if (size > 0) {
                firstIndex = nextOf(firstIndex);
            }
            shrinkArray();
        }
        return first;
    }

    public T removeLast() {
        T last = arr[lastIndex];
        if (last != null) {
            arr[lastIndex] = null;
            size--;
            if (size > 0) {
                lastIndex = prevOf(lastIndex);
            }
            shrinkArray();
        }
        return last;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            index = index + firstIndex;
            if (index >= arr.length) {
                index = index - arr.length;
            }
            return arr[index];
        }
    }


    private int nextOf(int index) {
        if (index == arr.length - 1) {
            return 0;
        }
        return index + 1;
    }

    private int prevOf(int index) {
        if (index == 0) {
            return arr.length - 1;
        }
        return index - 1;
    }


    private void extendArray() {
        if (arr.length == size) {
            T[] newArr = (T[]) new Object[size * 2];
            boolean moveToNext = prevOf(firstIndex) == lastIndex;
            for (int i = 0; i < size; i++) {
                newArr[i] = arr[firstIndex];
                if (moveToNext) {
                    firstIndex = nextOf(firstIndex);
                } else {
                    firstIndex = prevOf(firstIndex);
                }
            }
            arr = newArr;
            firstIndex = 0;
            lastIndex = size - 1;
        }
    }

    private void shrinkArray() {
        if (size >= 16 && arr.length / size > 4) {
            T[] newArr = (T[]) new Object[arr.length / 2];
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = arr[firstIndex];
                firstIndex = nextOf(firstIndex);
            }
            arr = newArr;
            firstIndex = 0;
            lastIndex = size - 1;
        }
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int index = 0;


        public boolean hasNext() {
            return index < size;
        }


        public T next() {
            if (index < size) {
                return get(index++);
            }
            return null;
        }
    }
}
