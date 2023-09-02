package org.chees.clean.moving.strategy;

import org.chees.clean.board.position.Position;
import org.chees.clean.moving.equation.Equation;
import org.chees.clean.moving.equation.implementation.DiagonalEquation;
import org.chees.clean.moving.equation.implementation.HorizontalEquation;
import org.chees.clean.moving.equation.implementation.VerticalEquation;
import org.chees.clean.piece.Piece;

import java.util.List;

public interface MoveStrategy {

    static MoveStrategy knightMoveStrategy() {
        return piece -> {
            Position position = piece.position();
            double a = 0.5;
            double y = position.number();
            double halfX = a * position.letter().getValue();
            return List.of(new DiagonalEquation(a, y - halfX), new DiagonalEquation(-a, y + halfX));
        };
    }

    static MoveStrategy pawnMoveStrategy() {
        return piece -> List.of(new VerticalEquation(piece.position().letter().getValue()));
    }

    static MoveStrategy queenMoveStrategy() {
        return piece -> {
            Position position = piece.position();
            int number = position.number();
            int letter = position.letter().getValue();
            return List.of(new VerticalEquation(letter),
                    new HorizontalEquation(number),
                    new DiagonalEquation(1, number - letter),
                    new DiagonalEquation(1, number + letter));
        };
    }

    static MoveStrategy rookMoveStrategy() {
        return piece -> List.of();
    }

    static MoveStrategy bishopMoveStrategy() {
        return piece -> List.of();
    }

    static MoveStrategy kingMoveStrategy() {
        return piece -> List.of();
    }

    List<Equation> getEquations(Piece piece);

}

