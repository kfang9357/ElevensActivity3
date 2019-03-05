package com.company;
public class Shuffler {

    private static final int SHUFFLE_COUNT = 1;

    public static void main(String[] args) {
        System.out.println("Results of " + SHUFFLE_COUNT +
                " consecutive perfect shuffles:");
        int[] values1 = {1,2,3,4,5,6,7,8,9,10};
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
        int mid = (values.length + 1)/2;

        int k = 0;
        for (int j = 0; j < mid; j++) {
            shuffled[k] = values[j];
            k += 2;
        }

        k = 1;
        for (int j = mid; j < values.length; j++) {
            shuffled[k] = values[j];
            k += 2;
        }

        for (int j = 0; j< values.length; j++)
        {
            values[j] = shuffled[j];
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

/** Consider the following “perfect shuffle” algorithm that starts with an array named cards that contains
 52 cards and creates an array named shuffled.
 Initialize shuffled to contain 52 “empty” elements.
 Set k to 0.
 For j = 0 to 25,
 − Copy cards[j] to shuffled[k];
 − Set k to k+2.
 Set k to 1.
 For j = 26 to 51,
 − Copy cards[j] to shuffled[k];
 − Set k to k+2.

 This approach moves the first half of cards to the even index positions of shuffled, and it moves
 the second half of cards to the odd index positions of shuffled.
 The above algorithm shuffles 52 cards. If an odd number of cards is shuffled, the array shuffled has
 one more even-indexed position than odd-indexed positions. Therefore, the first loop must copy one
 more card than the second loop does. This requires rounding up when calculating the index of the middle
 of the deck. In other words, in the first loop j must go up to (cards.length + 1) / 2,
 exclusive, and in the second loop j most begin at (cards.length + 1) / 2.

 **/