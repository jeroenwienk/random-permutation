package nl.jwienk.permutaties.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class Helpers {
    private Helpers() {}

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static boolean isUniqueArray(int[] array) {
        Set<Integer> numbers = new HashSet<>();
        for (int i : array) {
            numbers.add(i);
        }
        return numbers.size() == array.length;
    }
}
