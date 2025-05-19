package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class HarpHeroLite {
    public static final double CONCERT_A = 440.0;
    private static final String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static final int KEYBOARD_LENGTH = KEYBOARD.length();

    private static double getFrequency(int index) {
        return 440 * Math.pow(2, (double) (index - 24) / 12);
    }

    public static void main(String[] args) {


        HarpString[] harps = new HarpString[KEYBOARD_LENGTH];

        for (int i = 0; i < KEYBOARD_LENGTH; i++) {
            harps[i] = new HarpString(getFrequency(i));
        }
        int keyIndex = 0;
        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();

                if (KEYBOARD.contains(String.valueOf(key))) {
                    keyIndex = KEYBOARD.indexOf(key);
                    harps[keyIndex].pluck();
                }
            }


            StdAudio.play(harps[keyIndex].sample());

            harps[keyIndex].tic();
        }
    }
}

