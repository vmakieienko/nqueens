package com.nqueens;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.nqueens.ThreeInLinePredicateTest.Element.DOT;
import static com.nqueens.ThreeInLinePredicateTest.Element.TOD;
import static com.nqueens.ThreeInLinePredicateTest.Element.___;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class ThreeInLinePredicateTest {
    private final ThreeInLinePredicate tested = new ThreeInLinePredicate();

    @Test
    public void isValid() {
        assertFalse(tested.isValid(Arrays.asList(0, 100, 1, 107), 2));
        assertTrue(tested.isValid(Arrays.asList(0, 100, 1, 107), 3));
    }

    @Test
    public void isValidHorizontalLine() {
        assertFalse(isValid(new Element[][]{
                {___, ___, ___},
                {___, ___, ___},
                {DOT, DOT, DOT}
        }));
    }

    @Test
    public void minimalValidCase() {
        assertTrue(isValid(new Element[][]{
                {___, ___, ___},
                {___, DOT, DOT},
                {DOT, ___, ___}
        }));
    }

    @Test
    public void isValidDiagonal() {
        assertFalse(isValid(new Element[][]{
                {___, ___, DOT},
                {___, DOT, ___},
                {DOT, ___, ___}
        }));
    }

    @Test
    public void isValidDiagonalWithGap() {
        assertFalse(isValid(new Element[][]{
                {___, ___, ___, DOT},
                {___, ___, ___, ___},
                {___, DOT, TOD, ___},
                {DOT, ___, ___, ___}
        }));
        assertFalse(isValid(new Element[][]{
                {___, ___, ___, DOT},
                {___, TOD, DOT, ___},
                {___, ___, ___, ___},
                {DOT, ___, ___, ___}
        }));
    }

    @Test
    public void isValid2x1() {
        assertFalse(isValid(new Element[][]{
                {___, TOD, ___, TOD, ___},
                {___, ___, ___, ___, ___},
                {___, ___, ___, ___, DOT},
                {___, ___, DOT, ___, ___},
                {DOT, ___, ___, ___, ___}
        }));
    }

    @Test
    public void isValidNoLine() {
        assertTrue(isValid(new Element[][]{
                {___, TOD, ___, TOD, ___},
                {___, ___, ___, ___, ___},
                {___, ___, ___, ___, ___},
                {___, ___, DOT, ___, DOT},
                {DOT, ___, ___, ___, ___}
        }));
    }

    private boolean isValid(Element[][] board) {
        final int size = board.length;
        final List<Integer> validPositions = new ArrayList<>();
        for (int column = 0; column < size - 1; column++) {
            for (int row = 0; row < size; row++) {
                if (board[row][column] != ___) {
                    validPositions.add(row);
                    break;
                }
            }
        }
        int newPosition = -1;
        for (int row = 0; row < size; row++) {
            if (board[row][size - 1] != ___) {
                newPosition = row;
                break;
            }
        }

        assertEquals(size - 1, validPositions.size());
        assertNotEquals(-1, newPosition);

        return tested.isValid(validPositions, newPosition);
    }

    enum Element {
        DOT, // piece on board
        ___, // empty space on board
        TOD  // piece on board, same as DOT from the test perspective. Unimportant for programmer.
    }
}