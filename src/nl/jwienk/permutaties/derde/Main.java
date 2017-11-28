package nl.jwienk.permutaties.derde;

import nl.jwienk.permutaties.utils.Contants;
import nl.jwienk.permutaties.utils.Helpers;

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

    public static void main(String[] args) {
        //generateRandomPermutations(Contants.SIZES_TEST, true);
        generateRandomPermutations(Contants.SIZES_THIRD, false);
    }

    private static void generateRandomPermutations(int[] sizes, boolean printContents) {
        for (int size : sizes) {
            int[] elements = new int[size];
            boolean[] used = new boolean[size];
            int nrOfRandomsGenerated = 0;

            long startTime = System.nanoTime();
            for (int i = 0; i < elements.length; i++) {
                int number = random.nextInt(size);
                nrOfRandomsGenerated++;

                while (used[number]) {
                    number = random.nextInt(size);
                    nrOfRandomsGenerated++;
                }

                elements[i] = number;
                used[number] = true;
            }
            long endTime = System.nanoTime();
            long durationInMs = ((endTime - startTime) / 1000000);

            System.out.format("%-24s%-24d%n", "size", size);
            System.out.format("%-24s%-24d%n", "durationInMs", durationInMs);
            System.out.format("%-24s%-24s%n", "unique", Helpers.isUniqueArray(elements));
            System.out.format("%-24s%-24d%n", "nrOfRandomsGenerated", nrOfRandomsGenerated);

            if (printContents) {
                Helpers.printArray(elements);
            }

            System.out.println("");
        }
    }

}




