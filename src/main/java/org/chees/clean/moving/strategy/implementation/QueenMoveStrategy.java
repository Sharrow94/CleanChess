package org.chees.clean.moving.strategy.implementation;

import org.chees.clean.board.position.Position;
import org.chees.clean.moving.equation.Equation;
import org.chees.clean.moving.equation.implementation.HorizontalEquation;
import org.chees.clean.moving.equation.implementation.VerticalEquation;
import org.chees.clean.moving.equation.implementation.DiagonalEquation;
import org.chees.clean.moving.strategy.MoveStrategy;
import org.chees.clean.piece.Piece;

import java.util.List;

public class QueenMoveStrategy implements MoveStrategy {

    @Override
    public List<Equation> getEquations(Piece piece) {
        Position position = piece.position();
        int number = position.number();
        int letter = position.letter().getValue();
        return List.of(new VerticalEquation(letter),
                new HorizontalEquation(number),
                new DiagonalEquation(1, number - letter),
                new DiagonalEquation(1, number + letter));
    }
}
