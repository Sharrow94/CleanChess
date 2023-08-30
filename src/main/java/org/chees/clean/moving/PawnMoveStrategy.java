package org.chees.clean.moving;

import org.chees.clean.moving.equation.Equation;
import org.chees.clean.moving.equation.VerticalEquation;
import org.chees.clean.piece.Piece;

import java.util.List;

public class PawnMoveStrategy implements MoveStrategy {

    @Override
    public List<Equation> getMovementEquations(Piece piece) {
        return List.of(new VerticalEquation(piece.position().letter().getValue()));
    }
}
