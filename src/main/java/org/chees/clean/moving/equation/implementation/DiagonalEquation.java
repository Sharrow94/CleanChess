package org.chees.clean.moving.equation.implementation;

import org.chees.clean.board.position.Position;
import org.chees.clean.board.position.PositionCreatingException;
import org.chees.clean.board.position.PositionLetter;
import org.chees.clean.engine.Move;
import org.chees.clean.moving.equation.Equation;
import org.chees.clean.piece.Piece;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DiagonalEquation implements Equation {

    private final double a;

    private final double b;

    public DiagonalEquation(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean test(Position position) {
        return position.number() == a * position.letter().getValue() + b;
    }

    @Override
    public List<Move> getAvailableMoves(Piece piece) {
        Position currentPosition = piece.position();
        return Arrays.stream(PositionLetter.values())
                .filter(isNotCurrentPosition(currentPosition))
                .map(this::tryToCreatePosition)
                .filter(Objects::nonNull)
                .map(destination -> new Move(currentPosition, destination))
                .collect(Collectors.toList());
    }


    private Predicate<PositionLetter> isNotCurrentPosition(Position currentPosition) {
        return letter -> currentPosition.letter() != letter;
    }

    private Position tryToCreatePosition(PositionLetter letter) {
        try {
            return new Position(letter, (int) (a * letter.getValue() + b));
        } catch (PositionCreatingException exception) {
            return null;
        }
    }
}
