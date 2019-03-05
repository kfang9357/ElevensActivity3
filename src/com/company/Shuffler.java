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
        int[] values2 = {1,2,3,4,5,6,7,8,9,10};
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

        for (int k = values.length; k > 0; k--) {
            int j = (int)(Math.random() * (values.length + 1));
            int temp = values[j];
            values[j] = values[k];
            values[k] = temp;
            }
    }
}

