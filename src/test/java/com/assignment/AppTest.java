package com.assignment;

import com.assignment.model.NStrData;
import com.assignment.parser.NStrParser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testNStrParser() {

        List<String> input = Arrays.asList("Test test", "NStr(\"en = 'Deleting object';\");");

        NStrData data1 = new NStrData(2,"en","Deleting object");

        List<NStrData> expected = Arrays.asList(data1);
        List<NStrData> result = NStrParser.parseNstr(input);
        assertEquals(expected, result);
    }
}
