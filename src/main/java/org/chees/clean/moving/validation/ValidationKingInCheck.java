package org.chees.clean.moving.validation;

import org.chees.clean.board.ChessBoard;
import org.chees.clean.engine.Move;
import org.chees.clean.specification.composite.CompositeSpecification;

public class ValidationKingInCheck extends CompositeSpecification<Move> {

    private final ChessBoard board;

    public ValidationKingInCheck(ChessBoard board) {
        this.board = board;
    }

    @Override
    public boolean IsSatisfiedBy(Move candidate) {
        return false;
    }
}
