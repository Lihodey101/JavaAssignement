package com.assignment;

import com.assignment.model.NStrData;
import com.assignment.parser.NStrParser;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class NStrParserTest {
    @Test
    public void testParseNoRows() {
        List<String> input = Arrays.asList();
        List<NStrData> result = NStrParser.parseNstr(input);
        assertEquals(0, result.size());
    }
    @Test
    public void testParseCorrectTextRow() {
        List<String> input = Arrays.asList("NStr(\"en = 'Deleting object'; ru = 'Удаление объекта';\");");
        List<NStrData> result = NStrParser.parseNstr(input);
        assertEquals(2, result.size());
    }

    @Test
    public void testParseInvalidFormat() {
        List<String> input = Arrays.asList("NStr('en' 'Test');");
        List<NStrData> result = NStrParser.parseNstr(input);
        assertEquals(0, result.size());
    }

}
