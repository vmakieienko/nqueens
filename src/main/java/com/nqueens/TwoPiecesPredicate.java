package com.nqueens;

/**
 * Implementations of this interface will check if 2 chess pieces don't threaten each other.
 * This interface is to separate chess logic from back tracking algorithm logic.
 */
public interface TwoPiecesPredicate {
    /**
     * Check if two pieces are in safe positions related to each other.
     *
     * @param x1 - x-coordinate of the first piece
     * @param y1 - y-coordinate of the first piece
     * @param x2 - x-coordinate of the second piece
     * @param y2 - y-coordinate of the second piece
     * @return - true if pieces don't threaten each other.
     */
    boolean isSafe(int x1, int y1, int x2, int y2);

    default TwoPiecesPredicate and(TwoPiecesPredicate other) {
        return (int x1, int y1, int x2, int y2) -> isSafe(x1, y1, x2, y2) && other.isSafe(x1, y1, x2, y2);
    }

}
