package deque;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {

    @Test
    public void testMaxArrayDeque() {
        MaxArrayDeque<Integer> mad = new MaxArrayDeque<>(new IntComparator());
        mad.addLast(1);
        mad.addLast(65);
        mad.addLast(3);
        mad.addFirst(32);

        assertEquals(65, (int) mad.max());
        assertEquals(65, (int) mad.max(new IntComparator()));

    }

}
