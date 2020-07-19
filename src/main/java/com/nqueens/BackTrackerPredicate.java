package com.nqueens;

import java.util.List;

@FunctionalInterface
interface BackTrackerPredicate {
    /**
     * Implementations of this interface will check if suggested position is valid.
     * The algorithm operates on square board and assumes only one valid position per column.
     *
     * @param validPositions - list of already validated positions(row number, 0-based). Index in list corresponds to column number (0-based)
     * @param newPosition    - 0-based row number to check. Column number is implied by list size.
     * @return - true eif position is valid.
     */
    boolean isValid(List<Integer> validPositions, int newPosition);

    default BackTrackerPredicate and(BackTrackerPredicate other) {
        return (validPositions, newPosition) -> isValid(validPositions, newPosition) && other.isValid(validPositions, newPosition);
    }
}
