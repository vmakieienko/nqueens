package com.nqueens;

import static com.nqueens.AbstractTwoPiecesPredicateTest.BoardMarkers.DANGER;
import static com.nqueens.AbstractTwoPiecesPredicateTest.BoardMarkers._PIECE;
import static com.nqueens.AbstractTwoPiecesPredicateTest.BoardMarkers.__SAFE;

public class RookPredicateTest extends AbstractTwoPiecesPredicateTest {

    public RookPredicateTest() {
        super(new RookPredicate(), new BoardMarkers[][]{
                {__SAFE, __SAFE, DANGER, __SAFE},
                {__SAFE, __SAFE, DANGER, __SAFE},
                {DANGER, DANGER, _PIECE, DANGER},
                {__SAFE, __SAFE, DANGER, __SAFE},
        });
    }
}