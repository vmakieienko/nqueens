package com.nqueens;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class SquareBoardBackTrackerTest {
    private final SquareBoardBackTracker tested = new SquareBoardBackTracker();

    @Test
    public void solveForRook() throws SolutionNotFoundException {
        assertEquals(
                asList(0, 1, 2, 3),
                tested.solve(4, RookPredicate.createRookPredicate()));
        assertEquals(
                asList(0, 1, 2, 3, 4, 5, 6),
                tested.solve(7, RookPredicate.createRookPredicate()));
    }

    @Test
    public void solveForBishop() throws SolutionNotFoundException {
        assertEquals(
                asList(0, 0, 0, 0),
                tested.solve(4, BishopPredicate.createBishopPredicate()));
        assertEquals(
                asList(0, 0, 0, 0, 0, 0, 0),
                tested.solve(7, BishopPredicate.createBishopPredicate()));
    }

    @Test
    public void solveForQueen() throws SolutionNotFoundException {
        assertEquals(
                asList(1, 3, 0, 2),
                tested.solve(4, QueenPredicate.createQueenPredicate()));
        assertEquals(
                asList(0, 4, 7, 5, 2, 6, 1, 3),
                tested.solve(8, QueenPredicate.createQueenPredicate()));
    }

    @Test(expected = SolutionNotFoundException.class)
    public void solveNoSolution() throws SolutionNotFoundException {
        tested.solve(2, ((validPositions, newPosition) -> false));
    }
}