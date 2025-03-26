import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileReadingEfficiency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the file to read:");
        String filePath = sc.nextLine();

        compareFileReadingTime(filePath);
    }

    // Method to compare file reading execution time
    static void compareFileReadingTime(String filePath) {
        long startTimeFileReader = System.nanoTime();
        readFileWithFileReader(filePath);
        long endTimeFileReader = System.nanoTime();
        long durationTimeFileReader = (endTimeFileReader - startTimeFileReader) / 1000000;

        long startTimeInputStreamReader = System.nanoTime();
        readFileWithInputStreamReader(filePath);
        long endTimeInputStreamReader = System.nanoTime();
        long durationTimeInputStreamReader = (endTimeInputStreamReader - startTimeInputStreamReader) / 1000000;

        System.out.println("\nExecution Time for Reading File: \nUsing FileReader: " + durationTimeFileReader + "ms \nUsing InputStreamReader: " + durationTimeInputStreamReader + "ms");
    }

    // Method to read file using FileReader
    static void readFileWithFileReader(String filePath) {
        try (FileReader fileReader = new FileReader(filePath)) {
            while (fileReader.read() != -1) {
                // Read file character by character
            }
        }
        catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }
    }

    // Method to read file using InputStreamReader
    static void readFileWithInputStreamReader(String filePath) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
            while (inputStreamReader.read() != -1) {
                // Reading file byte by byte and converting it to characters
            }
        }
        catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
    }
}

/*
Input:
    Enter the file to read:
    ..\src\largeFile.txt
Output:
    Execution Time for Reading File:
    Using FileReader: 16ms
    Using InputStreamReader: 4ms
 */