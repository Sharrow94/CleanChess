package org.chees.clean.moving.validation;

import org.chees.clean.board.ChessBoard;
import org.chees.clean.engine.Move;
import org.chees.clean.specification.composite.CompositeSpecification;

public class ValidationCastling extends CompositeSpecification<Move> {

    private final ChessBoard chessBoard;

    public ValidationCastling(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    @Override
    public boolean IsSatisfiedBy(Move candidate) {
        chessBoard.pieces().stream().filter(piece -> piece.position().equals(candidate.from()))
                .filter(x -> true);
        return false;
    }
}
