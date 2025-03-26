public class FibonacciComputationComparison {
    public static void main(String[] args) {
        int[] fibonacciNumbers = {10, 30, 50};

        for (int n : fibonacciNumbers) {
            System.out.println("_____________________________");
            System.out.println("Fibonacci (N): " + n + "\n");

            compareFibonacci(n);
        }
    }

    // Method to compare execution time taken for fibonacci computation
    static void compareFibonacci(int n) {
        long startTimeRecursive = System.nanoTime();
        int resultRecursive = fibonacciRecursive(n);
        long endTimeRecursive = System.nanoTime();
        long durationTimeRecursive = (endTimeRecursive - startTimeRecursive) / 1000000;

        long startTimeIterative = System.nanoTime();
        int resultIterative = fibonacciIterative(n);
        long endTimeIterative = System.nanoTime();
        long durationTimeIterative = (endTimeIterative - startTimeIterative) / 1000000;

        System.out.println("Recursive (O(2^n)): \nExecution Time: " + durationTimeRecursive + "ms \nResult: " + resultRecursive);
        System.out.println("\nIterative (O(N)): \nExecution Time: " + durationTimeIterative + "ms \nResult: " + resultIterative);
    }

    // Method to calculate fibonacci recursively
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Method to calculate fibonacci iteratively
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}

/*
Output:
    _____________________________
    Fibonacci (N): 10

    Recursive (O(2^n)):
    Execution Time: 0ms
    Result: 55

    Iterative (O(N)):
    Execution Time: 0ms
    Result: 55
    _____________________________
    Fibonacci (N): 30

    Recursive (O(2^n)):
    Execution Time: 4ms
    Result: 832040

    Iterative (O(N)):
    Execution Time: 0ms
    Result: 832040
    _____________________________
    Fibonacci (N): 50

    Recursive (O(2^n)):
    Execution Time: 56482ms
    Result: -298632863

    Iterative (O(N)):
    Execution Time: 0ms
    Result: -298632863
 */