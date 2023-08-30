package org.chees.clean.moving;

import org.chees.clean.board.position.Position;
import org.chees.clean.moving.equation.Equation;
import org.chees.clean.moving.equation.HorizontalEquation;
import org.chees.clean.moving.equation.VerticalEquation;
import org.chees.clean.moving.equation.LinearEquation;
import org.chees.clean.piece.Piece;

import java.util.List;

public class QueenMoveStrategy implements MoveStrategy {

    @Override
    public List<Equation> getMovementEquations(Piece piece) {
        Position position = piece.position();
        int number = position.number();
        int letter = position.letter().getValue();
        return List.of(new VerticalEquation(letter),
                new HorizontalEquation(number),
                new LinearEquation(1, number - letter),
                new LinearEquation(1, number + letter));
    }
}
