package com.nqueens;

/**
 * Checks if 2 queens threaten each other.
 */

public class QueenPredicate implements TwoPiecesPredicate {
    private static final TwoPiecesPredicate queenPredicate = new RookPredicate().and(new BishopPredicate());

    public static BackTrackerPredicate createQueenPredicate() {
        return new BackTrackerTwoPiecesPredicate(queenPredicate);
    }

    @Override
    public boolean isSafe(int x1, int y1, int x2, int y2) {
        return queenPredicate.isSafe(x1, y1, x2, y2);
    }
}
