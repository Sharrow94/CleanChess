package org.chees.clean.moving.validation;

import org.chees.clean.board.ChessBoard;
import org.chees.clean.engine.Move;

public class ValidationCastling implements MoveValidation {

    private final ChessBoard chessBoard;

    public ValidationCastling(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    @Override
    public boolean test(Move move) {
        chessBoard.pieces().stream().filter(piece -> piece.position().equals(move.from()))
                .filter(x -> true);
        return false;
    }
}
