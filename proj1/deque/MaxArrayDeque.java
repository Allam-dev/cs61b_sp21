package deque;


import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;


    public MaxArrayDeque(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public T max() {
        if (isEmpty()) {
            return null;
        } else {
            T max = get(0);
            for (int i = 1; i < size(); i++) {
                int compareResult = comparator.compare(max, get(i));
                if (compareResult > 0) {
                    max = get(i);
                }
            }
            return max;
        }
    }

    public T max(Comparator<T> comparator) {
        if (isEmpty()) {
            return null;
        } else {
            T max = get(0);
            for (int i = 1; i < size(); i++) {
                int compareResult = comparator.compare(max, get(i));
                if (compareResult > 0) {
                    max = get(i);
                }
            }
            return max;
        }
    }
}
