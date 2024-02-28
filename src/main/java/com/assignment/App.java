package com.assignment;

import lombok.extern.slf4j.Slf4j;
import com.assignment.parser.NStrParser;
import com.assignment.util.FileHandler;
import java.util.stream.Collectors;
import com.assignment.model.NStrData;
import java.io.IOException;
import java.util.List;

@Slf4j
public class App {
    public static final String INPUT_FILE_PATH = "src/main/resources/inputFiles/ObjectModule.bsl";
    public static final String OUTPUT_FILE_PATH = "src/main/resources/outputFiles/output.txt";

    public static void main(String[] args) {
        try {
            List<String> rows = FileHandler.readFile(INPUT_FILE_PATH);
            List<NStrData> parsedData = NStrParser.parseNstr(rows);
            List<String> outputRows = parsedData.stream().map(NStrData::toString).collect(Collectors.toList());
            FileHandler.writeFile(OUTPUT_FILE_PATH, outputRows);
            log.info("File is saved at path: {}",OUTPUT_FILE_PATH);
        } catch (IOException e) {
            log.error("An error occurred: {}",e.getMessage());
        }
    }

}
