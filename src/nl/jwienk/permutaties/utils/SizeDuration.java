package nl.jwienk.permutaties.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class SizeDuration {
    private static final String COLUMN_DELIMITER = ",";
    private static final String LINE_DELIMITER = "\n";

    private Map<Integer, ArrayList<Long>> sizeDurations;

    public SizeDuration() {
        sizeDurations = new HashMap<>();
    }

    public void create(int size) {
        sizeDurations.put(size, new ArrayList<>());
    }

    public void addDuration(int size, long duration) {
        sizeDurations.get(size).add(duration);
    }

    public Map<Integer, ArrayList<Long>> getSizeDurations() {
        return sizeDurations;
    }

    public void toCSV() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("results.csv"));
        StringBuilder csv = new StringBuilder();

        ArrayList<Integer> keys = new ArrayList<>(sizeDurations.keySet());
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
            if (i != 0) {
                csv.append(SizeDuration.COLUMN_DELIMITER);
            }
            csv.append(keys.get(i));
        }
        csv.append(SizeDuration.LINE_DELIMITER);


        for (int j = 0; j < sizeDurations.get(keys.get(0)).size(); j++) {
            for (int i = 0; i < keys.size(); i++) {
                long value = sizeDurations.get(keys.get(i)).get(j);
                if (i != 0) {
                    csv.append(SizeDuration.COLUMN_DELIMITER);
                }
                csv.append(value);
            }
            csv.append(SizeDuration.LINE_DELIMITER);
        }

        pw.write(csv.toString());
        pw.close();
        System.out.println(csv.toString());
    }

}
