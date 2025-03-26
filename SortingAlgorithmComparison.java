import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithmComparison {
    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 100000};

        for (int size : datasetSizes) {
            int[] data = generateRandomArray(size);
            System.out.println("_____________________________");
            System.out.println("Dataset Size: " + size + "\n");

            int[] bubbleDataset = Arrays.copyOf(data, data.length);
            calculateTimeBubbleSort(bubbleDataset);

            int[] mergeDataset = Arrays.copyOf(data, data.length);
            calculateTimeMergeSort(mergeDataset, 0, mergeDataset.length - 1);

            int[] quickDataset = Arrays.copyOf(data, data.length);
            calculateTimeQuickSort(quickDataset, 0, quickDataset.length - 1);
        }
    }

    // Method to generate random array for datasets
    static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size * 2);
        }
        return array;
    }

    // Method to calculate execution time of bubble sort
    static void calculateTimeBubbleSort(int[] array) {
        long startTime = System.nanoTime();
        bubbleSort(array);
        double executionTime = (System.nanoTime() - startTime) / 1000000.0;
        System.out.println("Bubble Sort: \nExecution Time: " + executionTime + " ms\n");
    }

    // Method to calculate execution time of merge sort
    static void calculateTimeMergeSort(int[] array, int left, int right) {
        long startTime = System.nanoTime();
        mergeSort(array, left, right);
        double executionTime = (System.nanoTime() - startTime) / 1000000.0;
        System.out.println("Merge Sort: \nExecution Time: " + executionTime + " ms\n");
    }

    // Method to calculate execution time of quick sort
    static void calculateTimeQuickSort(int[] array, int low, int high) {
        long startTime = System.nanoTime();
        quickSort(array, low, high);
        double executionTime = (System.nanoTime() - startTime) / 1000000.0;
        System.out.println("Quick Sort: \nExecution Time: " + executionTime + " ms\n");
    }

    // Method to perform bubble sort to sort the dataset
    static void bubbleSort(int[] array) {
        if (array == null || array.length <= 1) return;
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Method to perform merge sort to sort the dataset
    static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            }
            else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    // Method to perform quick sort to sort the dataset
    static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}

/*
Output:
    _____________________________
    Dataset Size: 1000

    Bubble Sort:
    Execution Time: 6.272 ms

    Merge Sort:
    Execution Time: 1.0642 ms

    Quick Sort:
    Execution Time: 0.542 ms

    _____________________________
    Dataset Size: 10000

    Bubble Sort:
    Execution Time: 115.5231 ms

    Merge Sort:
    Execution Time: 1.9633 ms

    Quick Sort:
    Execution Time: 1.2612 ms

    _____________________________
    Dataset Size: 100000

    Bubble Sort:
    Execution Time: 14888.2623 ms

    Merge Sort:
    Execution Time: 19.9781 ms

    Quick Sort:
    Execution Time: 7.9844 ms
 */