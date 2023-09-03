package org.chees.clean.moving.equation.implementation;

import org.chees.clean.board.position.Position;
import org.chees.clean.board.position.PositionLetter;
import org.chees.clean.engine.Move;
import org.chees.clean.moving.equation.Equation;
import org.chees.clean.piece.Piece;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HorizontalEquation implements Equation {

    private final int y;

    public HorizontalEquation(int y) {
        this.y = y;
    }

    private Predicate<PositionLetter> isNotCurrentPosition(Position currentPosition) {
        return letter -> currentPosition.letter() != letter;
    }

    @Override
    public boolean test(Position position) {
        return y == position.number();
    }

    @Override
    public List<Move> getAvailableMoves(Piece piece) {
        Position currentPosition = piece.position();
        return Arrays.stream(PositionLetter.values())
                .filter(isNotCurrentPosition(currentPosition))
                .map(letter -> new Position(letter, currentPosition.number()))
                .map(destination -> new Move(currentPosition, destination))
                .collect(Collectors.toList());
    }
}
