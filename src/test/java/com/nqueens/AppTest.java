package com.nqueens;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.Arrays;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;

public class AppTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog().muteForSuccessfulTests();

    @Test
    public void testEndToEndEightQueens() {
        App.main("8");
        // expected solution comes from wikipedia: https://en.wikipedia.org/wiki/Eight_queens_puzzle#Solutions , see #10
        assertEquals("a3, b5, c8, d4, e1, f7, g2, h6\n", systemOutRule.getLogWithNormalizedLineSeparator());
    }

    @Test
    public void testEndToEndNoSolutionFound() {
        App.main("2");
        assertEquals("No solution found.\n", systemOutRule.getLogWithNormalizedLineSeparator());
    }

    @Test
    public void encodeToString() {
        assertEquals("", App.positionsToString(emptyList()));
        assertEquals("a5, b3, c1, d2, e4", App.positionsToString(Arrays.asList(4, 2, 0, 1, 3)));
        assertEquals("a5, b7, c1, d4, e2, f8, g6, h3", App.positionsToString(Arrays.asList(4, 6, 0, 3, 1, 7, 5, 2)));
    }

    @Test
    public void numberPositionToString() {
        assertEquals("2", App.numberPositionToString(1));
        assertEquals("101", App.numberPositionToString(100));
    }

    @Test
    public void letterPositionToString() {
        assertEquals("a", App.letterPositionToString(0));
        assertEquals("b", App.letterPositionToString(1));
        assertEquals("z", App.letterPositionToString(25));
        assertEquals("ba", App.letterPositionToString(26));
        assertEquals("bx", App.letterPositionToString(49));
        assertEquals("dv", App.letterPositionToString(99));
    }

    @Test
    public void testEndToEndNoArgument() {
        App.main();
        final String expected = "" +
                "CLI util for n-queens problem solution.\n" +
                "Usage: <number-of-queens>\n" +
                "\t number-of-queens - integer representing number of queens to find positions for.\n" +
                "\t                    Chess board has the same dimensions by problem definition.\n";
        assertEquals(expected, systemOutRule.getLogWithNormalizedLineSeparator());
    }

    @Test
    public void testEndToEndNotANumberArgument() {
        App.main("abc");
        assertEquals("Can't parse 'abc' as a number.\n", systemOutRule.getLogWithNormalizedLineSeparator());
    }

    @Test
    public void testEndToEndNegativeArgument() {
        App.main("-1");
        assertEquals("Must be a number >0.\n", systemOutRule.getLogWithNormalizedLineSeparator());
    }
}
