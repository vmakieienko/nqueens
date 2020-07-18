package com.nqueens;

import static com.nqueens.AbstractTwoPiecesPredicateTest.BoardMarkers.DANGER;
import static com.nqueens.AbstractTwoPiecesPredicateTest.BoardMarkers._PIECE;
import static com.nqueens.AbstractTwoPiecesPredicateTest.BoardMarkers.__SAFE;

public class BishopPredicateTest extends AbstractTwoPiecesPredicateTest {
    public BishopPredicateTest() {
        super(new BishopPredicate(), new BoardMarkers[][]{
                {DANGER, __SAFE, __SAFE, __SAFE},
                {__SAFE, DANGER, __SAFE, DANGER},
                {__SAFE, __SAFE, _PIECE, __SAFE},
                {__SAFE, DANGER, __SAFE, DANGER},
        });
    }
}