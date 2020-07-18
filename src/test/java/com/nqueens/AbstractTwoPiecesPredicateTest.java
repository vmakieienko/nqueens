package com.nqueens;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.nqueens.AbstractTwoPiecesPredicateTest.BoardMarkers._PIECE;
import static com.nqueens.AbstractTwoPiecesPredicateTest.BoardMarkers.__SAFE;
import static org.junit.Assert.assertEquals;

public abstract class AbstractTwoPiecesPredicateTest {
    private final TwoPiecesPredicate tested;
    private final BoardMarkers[][] board;
    private final int bishopX;
    private final int bishopY;


    protected AbstractTwoPiecesPredicateTest(TwoPiecesPredicate predicate, BoardMarkers[][] board) {
        tested = predicate;
        this.board = board;
        bishopX = _PIECE.getX(board);
        bishopY = _PIECE.getY(board);
    }

    enum BoardMarkers {
        __SAFE, _PIECE, DANGER; // todo rename more visual

        int getX(BoardMarkers[][] board) {
            for (int x = 0; x < board.length; x++) {
                for (BoardMarkers boardMarkers : board[x]) {
                    if (boardMarkers == this) {
                        return x;
                    }
                }
            }
            throw new IllegalArgumentException();
        }

        int getY(BoardMarkers[][] board) {
            for (BoardMarkers[] markers : board) {
                for (int y = 0; y < markers.length; y++) {
                    BoardMarkers boardMarkers = markers[y];
                    if (boardMarkers == this) {
                        return y;
                    }
                }
            }
            throw new IllegalArgumentException();
        }
    }

    @Test
    public void isSafe() {
        for (int x = 0; x < board.length; x++) {
            final BoardMarkers[] column = board[x];
            for (int y = 0; y < column.length; y++) {
                assertEquals(message(bishopX, bishopY, x, y), column[y] == __SAFE, tested.isSafe(bishopX, bishopY, x, y));
                assertEquals(message(x, y, bishopX, bishopY), column[y] == __SAFE, tested.isSafe(x, y, bishopX, bishopY));
            }
        }
    }

    private String message(int x1, int y1, int x2, int y2) {
        List<String> result = new ArrayList<>();
        for (int x = 0; x < board.length; x++) {
            final BoardMarkers[] column = board[x];
            List<String> columnStrings = new ArrayList<>();
            for (int y = 0; y < column.length; y++) {
                String s = (x1 == x && y1 == y) || (x2 == x && y2 == y) ? column[y].toString() : "______";
                columnStrings.add(s);
            }
            result.add(String.join(" ", columnStrings));
        }
        return "\n" + String.join("\n", result);
    }

}