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

import java.util.List;

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
