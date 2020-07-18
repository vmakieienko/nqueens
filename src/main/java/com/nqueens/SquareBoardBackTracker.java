/*
 * Copyright © 2016-2020 Jelurida IP B.V.
 *
 * See the LICENSE.txt file at the top-level directory of this distribution
 * for licensing information.
 *
 * Unless otherwise agreed in a custom licensing agreement with Jelurida B.V.,
 * no part of this software, including this file, may be copied, modified,
 * propagated, or distributed except according to the terms contained in the
 * LICENSE.txt file.
 *
 * Removal or modification of this copyright notice is prohibited.
 *
 */

package com.nqueens;

import java.util.ArrayList;
import java.util.List;


public class SquareBoardBackTracker {
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
