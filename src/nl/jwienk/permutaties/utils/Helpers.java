package nl.jwienk.permutaties.utils;

import java.util.Arrays;

public final class Helpers {
    private Helpers() { }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void printResults(int size, long durationInMs, int[] elements, int nrOfRandomsGenerated) {
        System.out.format("%-24s%-24d%n", "size", size);
        System.out.format("%-24s%-24d%n", "durationInMs", durationInMs);
        System.out.format("%-24s%-24s%n", "unique", Helpers.isUniqueArray(elements));
        System.out.format("%-24s%-24d%n", "nrOfRandomsGenerated", nrOfRandomsGenerated);
    }

    private static boolean isUniqueArray(int[] array) {
        boolean[] used = new boolean[array.length];

        for (int number : array) {

            if (!used[number]) {
                used[number] = true;
            } else {
                return false;
            }

        }
        return true;
    }

    public static void writeToCSV(int[] sizes, long[][] durations) {

    }

}
