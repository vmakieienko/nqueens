package com.nqueens;

import com.google.common.math.IntMath;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Represents requirement: no three points can be placed on same line.
 * See test for three-in-line examples.
 */
public class ThreeInLinePredicate implements BackTrackerPredicate {
    /**
     * Checks only new position(x, y) against pairs of points represented by valid positions list.
     *
     * @param validPositions - list of already validated positions(row number, 0-based).
     *                       Index in list corresponds to column number (0-based)
     * @param newPositionY   - suggested position to be checked not to form third point in line.
     * @return true - if no 3 in line found.
     */
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
