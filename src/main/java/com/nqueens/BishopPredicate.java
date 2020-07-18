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
