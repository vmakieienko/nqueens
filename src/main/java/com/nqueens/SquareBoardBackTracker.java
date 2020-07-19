package com.nqueens;

import java.util.ArrayList;
import java.util.List;


/**
 * Implementation of backtracking algorithm fore square board.
 * It searches for valid position in each column, one by one.
 * It assumes that one and only one valid position(row) exists in each column.
 * All positions are 0-based.
 */
class SquareBoardBackTracker {
    /**
     * @param boardSize - size of the board, also number of row+column positions to find.
     * @param partialSolutionPredicate - predicate to check if suggested new position is valid regarding already determined valid positions.
     * @return - list of row numbers, each in list position corresponding to column number.
     * @throws SolutionNotFoundException - if solution was not found for this board size and predicate.
     */
    List<Integer> solve(int boardSize, BackTrackerPredicate partialSolutionPredicate) throws SolutionNotFoundException {
        List<Integer> result = new ArrayList<>();
        if (solve(result, boardSize, partialSolutionPredicate)) {
            return result;
        } else {
            throw new SolutionNotFoundException();
        }
    }

    private boolean solve(List<Integer> positions, int boardSize, BackTrackerPredicate partialSolutionPredicate) {
        for (int newPosition = 0; newPosition < boardSize; newPosition++) {
            if (partialSolutionPredicate.isValid(positions, newPosition)) {
                positions.add(newPosition);
                if (positions.size() == boardSize) {
                    return true;
                }
                if (solve(positions, boardSize, partialSolutionPredicate)) {
                    return true;
                }
                positions.remove(positions.size() - 1);
            }
        }
        return false;
    }
}
