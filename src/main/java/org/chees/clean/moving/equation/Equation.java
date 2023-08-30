package org.chees.clean.moving.equation;

import org.chees.clean.board.position.Position;
import org.chees.clean.piece.Piece;

import java.math.BigDecimal;

/**
 * Mathematical formula for moving pieces
 */

public  interface Equation {

    boolean test(Position position);
}
