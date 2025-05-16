package gh2;

import deque.ArrayDeque;
import deque.Deque;

public class HarpString {
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor
    private long bufferSize = 0;

    /* Buffer for storing sound data. */
    private Deque<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public HarpString(double frequency) {
        bufferSize = Math.round(SR / frequency) * 2;
        buffer = new ArrayDeque<Double>();
        for (int i = 0; i < bufferSize; i++) {
            buffer.addLast(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        double r = 0.0;
        Deque<Double> tmp = new ArrayDeque<>();
        for (int i = 0; i < bufferSize; i++) {
            r = Math.random() - 0.5;
            tmp.addLast(r);
        }
        buffer = tmp;
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double first = buffer.removeFirst();
        double second = buffer.get(0);
        double newTone = DECAY * ((first + second) / 2);
        if (newTone != 0) {
            newTone = newTone * -1;
        }
        buffer.addLast(newTone);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.get(0);
    }
}
