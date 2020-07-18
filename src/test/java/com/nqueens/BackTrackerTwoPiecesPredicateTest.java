package com.nqueens;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BackTrackerTwoPiecesPredicateTest {

    @Test
    public void isValidIteratesPositions() {
        final RecordingPredicate recordingPredicate = new RecordingPredicate();
        BackTrackerTwoPiecesPredicate tested = new BackTrackerTwoPiecesPredicate(recordingPredicate);
        final boolean actualIsValid = tested.isValid(Arrays.asList(3, 6, 1, 0), 7);
        assertTrue(actualIsValid);
        assertEquals("(0, 3):(4, 7); (1, 6):(4, 7); (2, 1):(4, 7); (3, 0):(4, 7)", recordingPredicate.getCalledFor());
    }

    @Test
    public void isValidStopsOnFirstInvalid() {
        final RecordingPredicate recordingPredicate = new RecordingPredicate();
        BackTrackerTwoPiecesPredicate tested = new BackTrackerTwoPiecesPredicate(recordingPredicate);
        final boolean actualIsValid = tested.isValid(Arrays.asList(3, 7, 1, 0), 7);
        assertFalse(actualIsValid);
        assertEquals("(0, 3):(4, 7); (1, 7):(4, 7)", recordingPredicate.getCalledFor());
    }

    private static class RecordingPredicate implements TwoPiecesPredicate {
        private final List<String> calledFor = new ArrayList<>();

        @Override
        public boolean isSafe(int x1, int y1, int x2, int y2) {
            calledFor.add(String.format("(%s, %s):(%s, %s)", x1, y1, x2, y2));
            return y1 != y2;
        }

        String getCalledFor() {
            return String.join("; ", calledFor);
        }
    }
}