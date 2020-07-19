package com.nqueens;

import java.util.List;

/**
 * Adapter turning instance of {@link com.nqueens.TwoPiecesPredicate} to {@link com.nqueens.BackTrackerPredicate}
 */
class BackTrackerTwoPiecesPredicate implements BackTrackerPredicate {
    private final TwoPiecesPredicate predicate;

    BackTrackerTwoPiecesPredicate(TwoPiecesPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean isValid(List<Integer> validPositions, int newPosition) {
        final int newIndex = validPositions.size();
        int index = 0;
        for (int position : validPositions) {
            if (!predicate.isSafe(index, position, newIndex, newPosition)) {
                return false;
            }
            index++;
        }
        return true;
    }
}
