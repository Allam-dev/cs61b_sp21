package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> aListNoResizing = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();

        aListNoResizing.addLast(5);
        buggyAList.addLast(5);

        aListNoResizing.addLast(10);
        buggyAList.addLast(10);

        aListNoResizing.addLast(20);
        buggyAList.addLast(20);

        for (int i = 0; i < 3; i++) {
            assertEquals(aListNoResizing.getLast(), buggyAList.getLast());
        }
    }

    @Test
    public void  randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggyAList.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int buggySize = buggyAList.size();
                assertEquals(size, buggySize);
            }else if(operationNumber == 2 && L.size()>0){
                int lGetLast = L.getLast();
                int buggyGetLast = buggyAList.getLast();
                assertEquals(lGetLast, buggyGetLast);
                int lRemoveLast = L.removeLast();
                int buggyRemoveLast = buggyAList.removeLast();
                assertEquals(lRemoveLast, buggyRemoveLast);
            }
        }
    }
}
