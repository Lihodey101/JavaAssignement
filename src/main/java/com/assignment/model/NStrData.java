package com.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NStrData {
    private int rowNumber;
    private String languageCode;
    private String text;

    @Override
    public String toString() {
        return rowNumber + ": " + languageCode + " : " + text;
    }
}
