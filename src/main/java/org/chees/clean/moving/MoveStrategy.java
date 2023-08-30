package org.chees.clean.moving;

import org.chees.clean.moving.equation.Equation;
import org.chees.clean.piece.Piece;

import java.util.List;

public interface MoveStrategy {

    List<Equation> getMovementEquations(Piece piece);
}
