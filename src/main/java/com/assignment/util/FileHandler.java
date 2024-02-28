package com.assignment.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public static List<String> readFile(String filePath) throws IOException {
        List<String> rows = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String row;
            while ((row = reader.readLine()) != null) {
                rows.add(row);
            }
        }
        return rows;
    }

    public static void writeFile(String filePath, List<String> rows) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String row : rows) {
                writer.write(row);
                writer.newLine();
            }
        }
    }
}
