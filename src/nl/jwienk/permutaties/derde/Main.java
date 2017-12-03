package nl.jwienk.permutaties.derde;

import nl.jwienk.permutaties.utils.Contants;
import nl.jwienk.permutaties.utils.Helpers;
import nl.jwienk.permutaties.utils.SizeDuration;

import java.io.FileNotFoundException;
import java.util.Random;

/**
 * We willen een random permutatie genereren van de eerste N integers. Dergelijke permutaties
 * zijn vaak handig in simulaties. Zo zijn bijvoorbeeld [5,2,3,0,4,1] en [2,1,4,5,3,0] legale
 * permutaties (voor N=6), maar [1,0,2,4,2,5] niet want deze bevat tweemaal een 2 en geen 3.
 * Voor het creëren van een random permutatie van de getallen 0,...,N-1 hebben we de volgende
 * drie algoritmen:
 * <p>
 * 3. Voer voor elke waarde van i tussen 0 en N-1 de volgende stappen uit: zet op positie i
 * in het array een i, dus a[i] = i. Verwissel vervolgens meteen de inhoud van a[i] met
 * een willekeurige reeds gevulde positie in de array, dus swap(a[i], a[random getaltussen 0 en i]).
 */
public class Main {
    private static Random random = new Random();
    private static SizeDuration sizeDuration = new SizeDuration();

    public static void main(String[] args) {
        // generateRandomPermutations(Contants.SIZES_TEST, 10, true);
        generateRandomPermutations(Contants.SIZES_THIRD, 50, false);
    }

    private static void generateRandomPermutations(int[] sizes, int nrOfTimes, boolean printContents) {
        for (int size : sizes) {
            sizeDuration.create(size);
            for (int k = 0; k < nrOfTimes; k++) {

                int[] elements = new int[size];
                int nrOfRandomsGenerated = 0;

                long startTime = System.nanoTime();
                for (int i = 0; i < elements.length; i++) {
                    elements[i] = i;
                    swapWithRandomPosition(elements, i);
                    nrOfRandomsGenerated++;
                }
                long endTime = System.nanoTime();
                long durationInMs = ((endTime - startTime) / 1000000);
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

    private static void swapWithRandomPosition(int[] elements, int i) {
        int currentElement = elements[i];
        int swapPosition = random.nextInt(i + 1);
        int swapElement = elements[swapPosition];

        elements[i] = swapElement;
        elements[swapPosition] = currentElement;
    }

}




