package nl.jwienk.permutaties.utils;

/**
 * Algoritme 1 met N= 5.000, 10.000, 20.000, 50.000, 100.000, 200.000
 * Algoritme 2 met N= 100.000, 200.000, 500.000, 1.000.000, 5.000.000, 10.000.000
 * Algoritme 3 met N= 2.000.000, 5.000.000, 10.000.000, 20.000.000, 50.000.000, 100.000.000
 */

public final class Contants {
    private Contants() {}

    public static final int[] SIZES_FIRST = new int[]{5000, 10000, 20000, 50000, 100000, 200000};
    public static final int[] SIZES_SECOND = new int[]{100000, 200000, 500000, 1000000, 5000000, 10000000};
    public static final int[] SIZES_THIRD = new int[]{2000000, 5000000, 10000000, 20000000, 50000000, 100000000};
    public static final int[] SIZES_TEST = new int[]{5, 10, 20, 40, 80, 160};
}
