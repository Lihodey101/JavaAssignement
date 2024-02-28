package com.assignment;

import com.assignment.util.FileHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileHandlerTest {
    @TempDir
    Path temporaryDirectory;

    Path testFile;

    @BeforeEach
    void setUp() throws IOException {
        testFile = temporaryDirectory.resolve("test.txt");
        Files.write(testFile, Arrays.asList("Row 1", "Row 2"));
    }

    @Test
    void testReadFile() throws IOException {
        List<String> rows = FileHandler.readFile(testFile.toString());
        assertEquals(2, rows.size());
    }

    @Test
    void testWriteFile() throws IOException {
        List<String> initialRows = Arrays.asList("Row 3", "Row 4");
        FileHandler.writeFile(testFile.toString(), initialRows);
        List<String> readyRows = Files.readAllLines(testFile);
        assertTrue(readyRows.containsAll(initialRows));
    }
}
