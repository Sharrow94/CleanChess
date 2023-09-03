package org.chees.clean.moving.strategy;

import org.chees.clean.board.position.Position;
import org.chees.clean.engine.Move;
import org.chees.clean.moving.equation.implementation.DiagonalEquation;
import org.chees.clean.moving.equation.implementation.HorizontalEquation;
import org.chees.clean.moving.equation.implementation.VerticalEquation;
import org.chees.clean.piece.Piece;

import java.util.List;
import java.util.stream.Stream;

public interface MoveStrategy {

    static MoveStrategy knightMoveStrategy() {
        return piece -> {
            Position position = piece.position();
            double y = position.number();
            int x = position.letter().getValue();
            return Stream.of(0.5, -0.5, 2.0, -2.0)
                    .map(a -> new DiagonalEquation(a, y - a * x))
                    .flatMap(equation -> equation.getAvailableMoves(piece).stream())
                    .toList();
        };
    }

    static MoveStrategy pawnMoveStrategy() {
        return piece -> Stream.of(new VerticalEquation(piece.position().letter().getValue()))
                .flatMap(equation -> equation.getAvailableMoves(piece).stream())
                .toList();
    }

    static MoveStrategy queenMoveStrategy() {
        return MoveStrategy::allDirectionsMove;
    }

    static MoveStrategy rookMoveStrategy() {
        return piece -> {
            Position position = piece.position();
            int number = position.number();
            int letter = position.letter().getValue();
            return Stream.of(new VerticalEquation(letter),
                            new HorizontalEquation(number))
                    .flatMap(equation -> equation.getAvailableMoves(piece).stream())
                    .toList();
        };
    }

    static MoveStrategy bishopMoveStrategy() {
        return piece -> {
            Position position = piece.position();
            int number = position.number();
            int letter = position.letter().getValue();
            return Stream.of(new DiagonalEquation(1, number - letter),
                            new DiagonalEquation(1, number + letter))
                    .flatMap(equation -> equation.getAvailableMoves(piece).stream())
                    .toList();
        };
    }

    static MoveStrategy kingMoveStrategy() {
        return MoveStrategy::allDirectionsMove;

    }

    private static List<Move> allDirectionsMove(Piece piece) {
        Position position = piece.position();
        int number = position.number();
        int letter = position.letter().getValue();
        return Stream.of(new VerticalEquation(letter),
                        new HorizontalEquation(number),
                        new DiagonalEquation(1, number - letter),
                        new DiagonalEquation(-1, number + letter))
                .flatMap(equation -> equation.getAvailableMoves(piece).stream())
                .toList();
    }

    List<Move> getAvailableMoves(Piece piece);
}

