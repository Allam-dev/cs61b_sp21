package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class HarpHeroLite {
    public static final double CONCERT_A = 440.0;
    private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static final int keyboardLength = keyboard.length();

    private static double getFrequency(int index) {
        return 440 * Math.pow(2, (double) (index - 24) / 12);
    }

    public static void main(String[] args) {


        HarpString[] harps = new HarpString[keyboardLength];

        for (int i = 0; i < keyboardLength; i++) {
            harps[i] = new HarpString(getFrequency(i));
        }
        int keyIndex = 0;
        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();

                if (keyboard.contains(String.valueOf(key))) {
                    keyIndex = keyboard.indexOf(key);
                    harps[keyIndex].pluck();
                }
            }


            StdAudio.play(harps[keyIndex].sample());

            harps[keyIndex].tic();
        }
    }
}

