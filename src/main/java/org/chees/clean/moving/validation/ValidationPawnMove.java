package org.chees.clean.moving.validation;

import org.chees.clean.board.ChessBoard;
import org.chees.clean.engine.Move;
import org.chees.clean.piece.Color;
import org.chees.clean.piece.Piece;
import org.chees.clean.specification.composite.CompositeSpecification;

import static org.chees.clean.piece.Color.BLACK;
import static org.chees.clean.piece.Color.WHITE;

public class ValidationPawnMove extends CompositeSpecification<Move> {

    private final ChessBoard chessBoard;

    public ValidationPawnMove(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    private static boolean isPawnFirstMove(Piece piece) {
        Color color = piece.color();
        int row = piece.position().number();
        return color == WHITE && row == 2 || color == BLACK && row == 7;
    }

    @Override
    public boolean IsSatisfiedBy(Move candidate) {
        return chessBoard.pieces().stream().filter(piece -> piece.position().equals(candidate.from()))
                .findFirst()
                .filter(piece -> isCorrectDirection(piece, candidate))
                .map(piece -> isCorrectDelta(piece, candidate)).orElse(false);
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
