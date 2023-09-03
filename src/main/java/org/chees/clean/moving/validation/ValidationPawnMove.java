package org.chees.clean.moving.validation;

import org.chees.clean.engine.Move;
import org.chees.clean.piece.Color;
import org.chees.clean.piece.Piece;

import java.util.List;

import static org.chees.clean.piece.Color.BLACK;
import static org.chees.clean.piece.Color.WHITE;

public class ValidationPawnMove implements MoveValidation {

    private final List<Piece> pieces;

    public ValidationPawnMove(List<Piece> pieces) {
        this.pieces = pieces;
    }

    private static boolean isPawnFirstMove(Piece piece) {
        Color color = piece.color();
        int row = piece.position().number();
        return color == WHITE && row == 2 || color == BLACK && row == 7;
    }

    @Override
    public boolean test(Move move) {
        return pieces.stream().filter(piece -> piece.position().equals(move.from()))
                .findFirst()
                .filter(piece -> isCorrectDirection(piece, move))
                .map(piece -> isCorrectDelta(piece, move)).orElse(false);
    }

    private boolean isCorrectDirection(Piece piece, Move move) {
        int toRow = move.to().number();
        int fromRow = move.from().number();
        return piece.color() == WHITE ? toRow > fromRow : fromRow > toRow;
    }

    private boolean isCorrectDelta(Piece piece, Move move) {
        int delta = isPawnFirstMove(piece) ? 2 : 1;
        return Math.abs(move.from().number() - move.to().number()) == delta;
    }
}
