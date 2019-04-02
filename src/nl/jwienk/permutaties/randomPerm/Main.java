package nl.jwienk.permutaties.randomPerm;

import nl.jwienk.permutaties.utils.Contants;
import nl.jwienk.permutaties.utils.Helpers;
import nl.jwienk.permutaties.utils.SizeDuration;

import java.io.FileNotFoundException;
import java.util.Random;

/**
 * We willen een random permutatie genereren van de randomPerm N integers. Dergelijke permutaties
 * zijn vaak handig in simulaties. Zo zijn bijvoorbeeld [5,2,3,0,4,1] en [2,1,4,5,3,0] legale
 * permutaties (voor N=6), maar [1,0,2,4,2,5] niet want deze bevat tweemaal een 2 en geen 3.
 * Voor het creëren van een random permutatie van de getallen 0,...,N-1 hebben we de volgende
 * drie algoritmen:
 *
 * 1. Vul een voor een de elementen a[0] tot a[N-1] van de array a. Om element a[i] te
 * vullen, genereer je net zo lang een random getal totdat er een is gevonden die niet
 * gelijk is aan a[0] t/m a[i-1].
 */
public class Main {
    private static Random random = new Random();
    private static SizeDuration sizeDuration = new SizeDuration();

    public static void main(String[] args) {
        // generateRandomPermutations(Contants.SIZES_TEST, 10, true);
        generateRandomPermutations(Contants.SIZES_FIRST, 10, false);
    }

    /**
     *
     * @param sizes Welke sizes dit algoritme allemaal moet doorlopen
     * @param nrOfTimes Aantal keren dat het algoritme moet lopen
     * @param printContents Of de contents van de array naar de console moet worden geprint
     */
    private static void generateRandomPermutations(int[] sizes, int nrOfTimes, boolean printContents) {
        // loopen door alle sizes die gemeten moeten worden
        for (int size : sizes) {
            // maak een nieuwe entry voor de huidige size
            sizeDuration.create(size);

            // loopen door het aantal keren dat elke size gemeten moet worden
            for (int k = 0; k < nrOfTimes; k++) {

                int[] elements = new int[size];
                int nrOfRandomsGenerated = 0;

                // begin hier met meten van tijd want vanaf hier loopt de te meten code
                long startTime = System.nanoTime();
                for (int i = 0; i < elements.length; i++) {
                    int number = random.nextInt(size);
                    nrOfRandomsGenerated++;

                    int j = 0;
                    while (j < i) {
                        if (elements[j] == number) {
                            number = random.nextInt(size);
                            nrOfRandomsGenerated++;
                            j = 0;
                        } else {
                            j++;
                        }
                    }

                    elements[i] = number;
                }
                // einde meting
                long endTime = System.nanoTime();
                long durationInMs = ((endTime - startTime) / 1000000);

                // huidige resultaat toevoegen
                sizeDuration.addDuration(size, durationInMs);

                Helpers.printResults(size, durationInMs, elements, nrOfRandomsGenerated);
                if (printContents) {
                    Helpers.printArray(elements);
                }

                System.out.println("");
            }
        }

        try {
            sizeDuration.toCSV();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}




