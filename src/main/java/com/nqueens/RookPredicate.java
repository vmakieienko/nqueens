package com.nqueens;

/**
 * Checks if 2 rooks threaten each other.
 */
class RookPredicate implements TwoPiecesPredicate {
    static BackTrackerPredicate createRookPredicate() {
        return new BackTrackerTwoPiecesPredicate(new RookPredicate());
    }

    @Override
    public boolean isSafe(int x1, int y1, int x2, int y2) {
        return x1 != x2 && y1 != y2;
    }
}
