package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    @Test
    public void testNoPrimes() {
        IntList lst = IntList.of(20,30,22,4);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("20 -> 30 -> 22 -> 4", lst.toString());
    }

    @Test
    public void test4() {
        IntList lst = IntList.of(20,30,3,4);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("20 -> 30 -> 9 -> 4", lst.toString());
    }

    @Test
    public void testAllPrimes() {
        IntList lst = IntList.of(2,3,5,7,11,17,19,73);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 9 -> 25 -> 49 -> 121 -> 289 -> 361 -> 5329", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void test2() {
        IntList lst = IntList.of(2,4,6,8,10,12);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 4 -> 6 -> 8 -> 10 -> 12", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void test3() {
        IntList lst = IntList.of(1,5,11,21,7,-3,-2,-1,-5,-8,8);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("1 -> 25 -> 121 -> 21 -> 49 -> -3 -> -2 -> -1 -> -5 -> -8 -> 8", lst.toString());
//        assertTrue(changed);
    }

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }
}
