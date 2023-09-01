package org.chees.clean.moving.strategy.implementation;

import org.chees.clean.moving.equation.Equation;
import org.chees.clean.moving.equation.implementation.VerticalEquation;
import org.chees.clean.moving.strategy.MoveStrategy;
import org.chees.clean.piece.Piece;

import java.util.List;

public class PawnMoveStrategy implements MoveStrategy {

    @Override
    public List<Equation> getEquations(Piece piece) {
        return List.of(new VerticalEquation(piece.position().letter().getValue()));
    }
}
