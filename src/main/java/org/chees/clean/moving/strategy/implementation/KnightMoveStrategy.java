package org.chees.clean.moving.strategy.implementation;

import org.chees.clean.board.position.Position;
import org.chees.clean.moving.equation.Equation;
import org.chees.clean.moving.equation.implementation.DiagonalEquation;
import org.chees.clean.moving.strategy.MoveStrategy;
import org.chees.clean.piece.Piece;

import java.util.List;


public class KnightMoveStrategy implements MoveStrategy {

    @Override
    public List<Equation> getEquations(Piece piece) {
        Position position = piece.position();
        double a = 0.5;
        double y = position.number();
        double halfX = a * position.letter().getValue();
        return List.of(new DiagonalEquation(a, y - halfX), new DiagonalEquation(-a, y + halfX));
    }
}