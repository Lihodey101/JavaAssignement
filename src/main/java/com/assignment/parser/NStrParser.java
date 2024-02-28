package com.assignment.parser;


import com.assignment.model.NStrData;
import java.util.ArrayList;
import java.util.List;

public class NStrParser {
    public static List<NStrData> parseNstr(List<String> rows) {
        List<NStrData> parsedData = new ArrayList<>();
        int rowNumber = 0;
        for (String row : rows) {
            rowNumber++;
            if (row.contains("NStr(")) {
                //Find row which starts with NStr and separate strings in different languages
                String[] requiredStrings = row.split("NStr\\(")[1].split(",")[0].split(";");
                for (String str : requiredStrings) {
                    //  Separate language code and text
                    String[] stringValues = str.split("=");
                    if(stringValues.length == 2) {
                        String languageCode = stringValues[0].trim().replaceAll("[\"']", "");
                        String text = stringValues[1].replaceAll("[\"']", "").replace(");", "").trim();
                        parsedData.add(new NStrData(rowNumber, languageCode, text));
                    }
                }
            }
        }
        return parsedData;
    }
}
