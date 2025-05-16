package deque;

public interface Deque<T> extends Iterable<T> {
    public void addFirst(T item);

    public void addLast(T item);

    default public boolean isEmpty() {
        return size() == 0;
    }

    public int size();

    default public void printDeque() {
        String[] items = new String[size()];
        for (int i = 0; i < size(); i++) {
            items[i] = get(i).toString();
        }
        System.out.print('{' + String.join(", ", items) + '}');
    }

    public T removeFirst();

    public T removeLast();

    public T get(int index);

    public boolean equals(Object o);

}
