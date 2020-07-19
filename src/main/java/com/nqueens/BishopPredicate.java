package com.nqueens;

/**
 * Checks if 2 bishops threaten each other.
 */
class BishopPredicate implements TwoPiecesPredicate {
    static BackTrackerPredicate createBishopPredicate() {
        return new BackTrackerTwoPiecesPredicate(new BishopPredicate());
    }

    @Override
    public boolean isSafe(int x1, int y1, int x2, int y2) {
        return dist(x1, x2) != dist(y1, y2);
    }

    private static int dist(int pos1, int pos2) {
        return Math.abs(pos2 - pos1);
    }
}
