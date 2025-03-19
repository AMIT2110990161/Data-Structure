package StringAndIts_Functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CountWordReadFile {
    public static void main(String[] args) {
        File file = new File("D:\\BridgeLabz Development\\Data Structure\\src\\StringAndIts_Functions\\ReverseString.java");

        if (!file.exists()) {
            System.out.println("Error: File not found. Make sure '" + file + "' exists in the project directory.");
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
