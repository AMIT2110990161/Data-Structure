package StringAndIts_Functions;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        File file = new File("input.txt");

        if (!file.exists()) {
            System.out.println("Error: File not found. Make sure 'input.txt' exists in the project directory.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}


