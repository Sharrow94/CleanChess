package org.chees.clean.moving.equation.implementation;

import org.chees.clean.board.position.Position;
import org.chees.clean.engine.Move;
import org.chees.clean.moving.equation.Equation;
import org.chees.clean.piece.Piece;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VerticalEquation implements Equation {

    private final int x;

    public VerticalEquation(int x) {
        this.x = x;
    }

    @Override
    public boolean test(Position position) {
        return x == position.letter().getValue();
    }

    @Override
    public List<Move> getAvailableMoves(Piece piece) {
        Position currentPosition = piece.position();
        return IntStream.rangeClosed(1, 8)
                .filter(isNotCurrentPosition(currentPosition))
                .mapToObj(i -> new Move(currentPosition, new Position(currentPosition.letter(), i)))
                .collect(Collectors.toList());
    }

    private IntPredicate isNotCurrentPosition(Position currentPosition) {
        return i -> currentPosition.number() != i;
    }
}
