import java.util.Arrays;
import java.util.Random;

public class SearchAlgorithmComparison {
    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};
        int target = 5000;

        for (int size : datasetSizes) {
            int[] data = generateRandomArray(size);
            System.out.println("_____________________________");
            System.out.println("Dataset Size: " + size);
            System.out.println();

            // Linear Search
            long startTimeLinear = System.nanoTime();
            int linearResult = linearSearch(data, target);
            long endTimeLinear = System.nanoTime();
            double linearTime = (endTimeLinear - startTimeLinear) / 1_000_000.0;
            System.out.println("Linear Search: \nResult: " + linearResult + "\nExecution Time: " + linearTime + " ms");

            // Binary Search
            int[] sortedData = data.clone();
            long startTimeBinary = System.nanoTime();
            Arrays.sort(sortedData);
            int binaryResult = binarySearch(sortedData, target);
            long endTimeBinary = System.nanoTime();
            double binaryTime = (endTimeBinary - startTimeBinary) / 1_000_000.0;
            System.out.println("\nBinary Search: \nResult: " + binaryResult + "\nExecution Time: " + binaryTime + " ms");
        }
    }

    // Method to generate random array for dataset
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size * 2);
        }
        return array;
    }

    // Method to perform linear search to search the target in dataset
    public static int linearSearch(int[] array, int target) {
        if (array == null) return -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Method to perform binary search to search the target in dataset
    public static int binarySearch(int[] array, int target) {
        if (array == null) return -1;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (array[mid] == target) {
                return mid;
            }
            else if (array[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

/*
Output:
    _____________________________
    Dataset Size: 1000

    Linear Search:
    Result: -1
    Execution Time: 0.0212 ms

    Binary Search:
    Result: -1
    Execution Time: 1.2027 ms
    _____________________________
    Dataset Size: 10000

    Linear Search:
    Result: 4078
    Execution Time: 0.0769 ms

    Binary Search:
    Result: 2520
    Execution Time: 4.2048 ms
    _____________________________
    Dataset Size: 1000000

    Linear Search:
    Result: 296718
    Execution Time: 2.4185 ms

    Binary Search:
    Result: 2520
    Execution Time: 187.6806 ms
 */