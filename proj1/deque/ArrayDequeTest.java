package deque;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ArrayDequeTest {
    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */ public void addIsEmptySizeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */ public void addRemoveTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */ public void removeEmptyTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create ArrayDeques with different parameterized types*/ public void multipleParamTest() {


        ArrayDeque<String> lld1 = new ArrayDeque<String>();
        ArrayDeque<Double> lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty ArrayDeque. */ public void emptyNullReturnTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */ public void bigLLDequeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999; i > 500; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }


    }

    @Test
    public void testIterator() {
        ArrayDeque<Integer> arr = new ArrayDeque<Integer>();
        for (int i = 0; i <= 100; i++) {
            arr.addLast(i);
        }
        arr.removeLast();
        for (Integer x : arr) {
            System.out.println(x);
        }
    }

    @Test
    public void testEqualsDifferentObject() {
        ArrayDeque<String> arr = new ArrayDeque<>();
        String x = "hi";
        assertEquals(false, arr.equals(x));
    }

    @Test
    public void testEqualsDifferentGenericTypeWithSameLength() {

        ArrayDeque<Integer> arr1 = new ArrayDeque<>();
        ArrayDeque<String> arr2 = new ArrayDeque<>();

        for (int i = 0; i < 100; i++) {
            arr1.addFirst(i);
            arr2.addFirst(String.valueOf(i));
        }
        assertEquals(false, arr1.equals(arr2));

    }

    @Test
    public void testEqualsDifferentGenericTypeWithDifferentLength() {
        ArrayDeque<Integer> arr1 = new ArrayDeque<>();
        ArrayDeque<String> arr2 = new ArrayDeque<>();

        for (int i = 0; i < 100; i++) {
            arr1.addFirst(i);
        }

        for (int i = 0; i < 50; i++) {
            arr2.addFirst(String.valueOf(i));

        }

        assertEquals(false, arr1.equals(arr2));
    }

    @Test
    public void testEqualsSameGenericTypeWithSameLength() {
        ArrayDeque<String> arr1 = new ArrayDeque<>();
        ArrayDeque<String> arr2 = new ArrayDeque<>();

        for (int i = 0; i < 100; i++) {
            arr1.addFirst(String.valueOf(i));
            arr2.addFirst(String.valueOf(i));
        }
        assertEquals(true, arr1.equals(arr2));
    }

    @Test
    public void testEqualsSameGenericTypeWithDifferentLength() {
        ArrayDeque<String> arr1 = new ArrayDeque<>();
        ArrayDeque<String> arr2 = new ArrayDeque<>();

        for (int i = 0; i < 100; i++) {
            arr1.addFirst(String.valueOf(i));
        }

        for (int i = 0; i < 50; i++) {
            arr2.addFirst(String.valueOf(i));

        }

        assertEquals(false, arr1.equals(arr2));
    }

    @Test
    public void testEqualsAsSameObject() {
        ArrayDeque<String> arr1 = new ArrayDeque<>();

        assertEquals(true, arr1.equals(arr1));

    }

    @Test
    public void d3() {
        ArrayDeque<Integer> arr = new ArrayDeque<Integer>();
        arr.isEmpty();
        arr.addFirst(3);
        System.out.println(arr.removeLast());
        arr.addFirst(5);
        arr.isEmpty();
        System.out.println(arr.removeLast());

    }

    @Test
    public void d5() {
        ArrayDeque<Integer> arr = new ArrayDeque<Integer>();

        arr.addLast(2);
        System.out.println(arr.removeFirst());
        arr.isEmpty();
        arr.isEmpty();
        arr.addLast(6);
        System.out.println(arr.removeLast());
    }

    @Test
    public void d6() {
        ArrayDeque<Integer> arr = new ArrayDeque<Integer>();

        arr.addLast(0);
        System.out.println(arr.removeLast());
        arr.size();
        arr.addLast(3);
        arr.isEmpty();
        arr.addLast(5);
        System.out.println(arr.removeLast());
        arr.addLast(7);
        System.out.println(arr.removeLast());
        System.out.println(arr.removeFirst());
    }

    @Test
    public void d11() {
        ArrayDeque<Integer> arr = new ArrayDeque<Integer>();

        arr.addFirst(0);
        arr.addFirst(1);
        System.out.println(arr.removeLast());
        arr.addLast(3);
        System.out.println(arr.get(1));
    }
}
