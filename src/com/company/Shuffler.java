package com.company;
public class Shuffler {

    private static final int SHUFFLE_COUNT = 1;

    public static void main(String[] args) {
        System.out.println("Results of " + SHUFFLE_COUNT +
                " consecutive perfect shuffles:");
        int[] values1 = {0, 1, 2, 3};
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            perfectShuffle(values1);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values1.length; k++) {
                System.out.print(" " + values1[k]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Results of " + SHUFFLE_COUNT +
                " consecutive efficient selection shuffles:");
        int[] values2 = {0, 1, 2, 3};
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            selectionShuffle(values2);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values2.length; k++) {
                System.out.print(" " + values2[k]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void perfectShuffle(int[] values) {
        int[] shuffled = new int[values.length];

        int k = 0;
        for (int j = 0; j < 25; j++) {
            shuffled[k] = values[j];
            k += 2;
        }

        k = 1;
        for (int j = 26; j < values.length; j++) {
            shuffled[k] = values[j];
            k += 2;
        }

        for (int i = 0; i < values.length; i++) {
            values[k] = shuffled[k];
        }
    }

    public static void selectionShuffle(int[] values) {
        int[] shuffled = new int[values.length];

        for (int k = values.length; k > 0; k--) {
            int j = (int)(Math.random() * (k + 1));
            int temp = values[j];

            values[j] = values[k];
            values[k] = temp;
        }
    }
}

/** A better version, the “efficient selection shuffle,” works as follows:
 For k = 51 down to 1,
 − Generate a random integer r between 0 and k, inclusive;
 − Exchange cards[k] and cards[r].

 This has the same structure as selection sort:
 For k = 51 down to 1,
 − Find r, the position of the largest value among cards[0] through cards[k];
 − Exchange cards[k] and cards[r].

 The selection shuffle algorithm does not require to a loop to find the largest (or smallest) value to swap, so
 it works quickly.
 **/