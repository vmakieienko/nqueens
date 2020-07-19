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

import com.google.common.math.IntMath;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeInLinePredicate implements BackTrackerPredicate {
    @Override
    public boolean isValid(List<Integer> validPositions, int newPositionY) {
        final int newPositionX = validPositions.size();
        final Set<DxDy> set = new HashSet<>();
        for (int x = 0; x < newPositionX; x++) {
            final int distX = newPositionX - x;
            final int distY = newPositionY - validPositions.get(x);
            final int gcd = IntMath.gcd(distX, Math.abs(distY));
            final int dx = distX / gcd;
            final int dy = distY / gcd;
            if (!set.add(new DxDy(dx, dy))) {
                return false;
            }
        }
        return true;
    }

    private static class DxDy {
        private final int dx;
        private final int dy;

        private DxDy(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DxDy dxDy = (DxDy) o;

            if (dx != dxDy.dx) return false;
            return dy == dxDy.dy;
        }

        @Override
        public int hashCode() {
            int result = dx;
            result = 31 * result + dy;
            return result;
        }
    }
}
