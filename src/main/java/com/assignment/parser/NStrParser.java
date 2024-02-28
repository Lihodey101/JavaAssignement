package com.assignment.parser;


import com.assignment.model.NStrData;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NStrParser {
    public static List<NStrData> parseNstr(List<String> rows) {
        List<NStrData> parsedData = new ArrayList<>();
        int rowNumber = 0;
        for (String row : rows) {
            rowNumber++;
            if (row.contains("NStr(") && row.endsWith(");")) {
                // Extract string within NStr function
                Pattern pattern = Pattern.compile("NStr\\(\"(.*?)\"\\)");
                Matcher matcher = pattern.matcher(row);
                String extractedString = "";
                if (matcher.find()) {
                    extractedString = matcher.group(1);
                }
                // Separate strings in different languages which are divided by ;
                String[] langStrings = extractedString.split("';");
                for (String str : langStrings) {
                    // Separate language code and text
                    String[] stringValues = str.split("=");
                    if(stringValues.length == 2) {
                        String languageCode = stringValues[0].trim().replaceAll("[\"']", "");
                        String text = stringValues[1].replaceAll("[\'']", "").trim();
                        parsedData.add(new NStrData(rowNumber, languageCode, text));
                    }
                }
            }
        }
        return parsedData;
    }
}
