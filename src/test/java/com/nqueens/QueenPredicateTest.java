package com.nqueens;

import static com.nqueens.AbstractTwoPiecesPredicateTest.BoardMarkers.DANGER;
import static com.nqueens.AbstractTwoPiecesPredicateTest.BoardMarkers._PIECE;
import static com.nqueens.AbstractTwoPiecesPredicateTest.BoardMarkers.__SAFE;

public class QueenPredicateTest extends AbstractTwoPiecesPredicateTest {

    public QueenPredicateTest() {
        super(new QueenPredicate(), new BoardMarkers[][]{
                {DANGER, __SAFE, DANGER, __SAFE, DANGER},
                {__SAFE, DANGER, DANGER, DANGER, __SAFE},
                {DANGER, DANGER, _PIECE, DANGER, DANGER},
                {__SAFE, DANGER, DANGER, DANGER, __SAFE},
        });
    }
}