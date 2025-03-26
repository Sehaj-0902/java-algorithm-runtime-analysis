public class StringConcatenationPerformance {
    public static void main(String[] args) {
        int[] concatenations = {1000, 10000, 1000000};

        for (int count : concatenations) {
            System.out.println("_________________________________________");
            System.out.println("Number of Concatenations: " + count + "\n");

            compareStringConcatenation(count);
        }
    }

    // Method to compare string concatenation execution time
    static void compareStringConcatenation(int count) {
        long startTimeString = System.nanoTime();
        concatenateUsingString(count);
        double executionTimeString = (System.nanoTime() - startTimeString) / 1000000.0;
        System.out.println("String: \nExecution Time: " + executionTimeString + " ms\n");

        long startTimeStringBuilder = System.nanoTime();
        concatenateUsingStringBuilder(count);
        double executionTimeStringBuilder = (System.nanoTime() - startTimeStringBuilder) / 1000000.0;
        System.out.println("StringBuilder: \nExecution Time: " + executionTimeStringBuilder + " ms\n");

        long startTimeStringBuffer = System.nanoTime();
        concatenateUsingStringBuffer(count);
        double executionTimeStringBuffer = (System.nanoTime() - startTimeStringBuffer) / 1000000.0;
        System.out.println("StringBuffer: \nExecution Time: " + executionTimeStringBuffer + " ms");
    }

    // Method to concatenate strings using String
    static String concatenateUsingString(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += "a";
        }
        return result;
    }

    // Method to concatenate strings using StringBuilder
    static String concatenateUsingStringBuilder(int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append("a");
        }
        return result.toString();
    }

    // Method to concatenate strings using StringBuffer
    static String concatenateUsingStringBuffer(int count) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < count; i++) {
            result.append("a");
        }
        return result.toString();
    }
}

/*
Output:
    _________________________________________
    Number of Concatenations: 1000

    String:
    Execution Time: 3.1516 ms

    StringBuilder:
    Execution Time: 0.1719 ms

    StringBuffer:
    Execution Time: 0.334 ms
    _________________________________________
    Number of Concatenations: 10000

    String:
    Execution Time: 26.4293 ms

    StringBuilder:
    Execution Time: 0.9255 ms

    StringBuffer:
    Execution Time: 1.0125 ms
    _________________________________________
    Number of Concatenations: 1000000

    String:
    Execution Time: 89599.4377 ms

    StringBuilder:
    Execution Time: 24.1724 ms

    StringBuffer:
    Execution Time: 57.0386 ms
 */