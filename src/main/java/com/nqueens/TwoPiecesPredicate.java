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

public interface TwoPiecesPredicate {
    boolean isSafe(int x1, int y1, int x2, int y2);

    default TwoPiecesPredicate and(TwoPiecesPredicate other) {
        return (int x1, int y1, int x2, int y2) -> isSafe(x1, y1, x2, y2) && other.isSafe(x1, y1, x2, y2);
    }

}
