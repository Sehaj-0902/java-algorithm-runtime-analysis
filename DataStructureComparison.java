import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class DataStructureComparison {
    public static void main(String[] args) {
        int[] datasetSizes = {1000, 100000, 1000000};

        for (int size : datasetSizes) {
            System.out.println("_____________________________");
            System.out.println("Dataset Size (N): " + size + "\n");

            compareSearchResults(size);
        }
    }

    // Method to compare execution time taken to search value
    static void compareSearchResults(int size) {
        List<Integer> arrayList = generateArrayList(size);
        HashSet<Integer> hashSet = generateHashSet(size);

        int searchValue = generateSearchValue(size);

        long startTimeArray = System.nanoTime();
        boolean foundArray = searchInArray(arrayList, searchValue);
        long endTimeArray = System.nanoTime();
        long durationTimeArray = (endTimeArray - startTimeArray) / 1000000;

        long startTimeHashSet = System.nanoTime();
        boolean foundHashSet = searchInHashSet(hashSet, searchValue);
        long endTimeHashSet = System.nanoTime();
        long durationTimeHashSet = (endTimeHashSet - startTimeHashSet) / 1000000;

        System.out.println("Array Search (O(N)): \nExecution Time: " + durationTimeArray + "ms\nSearch Results: " + (foundArray ? "Value found" : "Value not found"));
        System.out.println("\nHashSet Search (O(1)): \nExecution Time: " + durationTimeHashSet + "ms\nSearch Results: " + (foundHashSet? "Value found" : "Value not found"));
    }

    // Method to generate random ArrayList
    static List<Integer> generateArrayList(int size) {
        List<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arrayList.add(random.nextInt(size * 2));
        }
        return arrayList;
    }

    // Method to generate random HashSet
    static HashSet<Integer> generateHashSet(int size) {
        HashSet<Integer> hashSet = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            hashSet.add(random.nextInt(size * 2));
        }
        return hashSet;
    }

    // Method to generate random search value
    static int generateSearchValue(int size) {
        Random random = new Random();
        return random.nextInt(size * 2);
    }

    // Method to search element using ArrayList
    static boolean searchInArray(List<Integer> arrayList, int searchValue) {
        for (int value : arrayList) {
            if (value == searchValue) {
                return true;
            }
        }
        return false;
    }

    // Method to search element using HashSet
    static boolean searchInHashSet(HashSet<Integer> hashSet, int searchValue) {
        return hashSet.contains(searchValue);
    }
}

/*
Output:
    _____________________________
    Dataset Size (N): 1000

    Array Search (O(N)):
    Execution Time: 0ms
    Search Results: Value not found

    HashSet Search (O(1)):
    Execution Time: 0ms
    Search Results: Value not found
    _____________________________
    Dataset Size (N): 100000

    Array Search (O(N)):
    Execution Time: 7ms
    Search Results: Value found

    HashSet Search (O(1)):
    Execution Time: 0ms
    Search Results: Value not found
    _____________________________
    Dataset Size (N): 1000000

    Array Search (O(N)):
    Execution Time: 2ms
    Search Results: Value found

    HashSet Search (O(1)):
    Execution Time: 0ms
    Search Results: Value not found
 */