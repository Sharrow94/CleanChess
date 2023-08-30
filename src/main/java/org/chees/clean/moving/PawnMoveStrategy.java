package org.chees.clean.moving;

import org.chees.clean.board.position.Position;
import org.chees.clean.board.position.PositionCreatingException;
import org.chees.clean.board.position.PositionLetter;
import org.chees.clean.piece.Pawn;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PawnMoveStrategy implements MoveStrategy<Pawn> {

    @Override
    public List<Position> getAvailablePositions(Pawn piece) {
        int colorValue = piece.getColor().getValue();
        Position currentPosition = piece.getPosition();
        return IntStream.rangeClosed(1, piece.isFirstMove() ? 2 : 1)
                .mapToObj(offset -> colorValue * offset + currentPosition.number())
                .map(number -> createPosition( currentPosition.letter(),number))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Position createPosition( PositionLetter letter,Integer number) {
        try {
            return new Position(letter, number);
        } catch (PositionCreatingException e) {
            return null;
        }
    }

    @Override
    public List<Equation> getMovementEquation(Pawn piece) {
        return Collections.emptyList();
    }
}
