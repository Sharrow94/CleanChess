package org.chees.clean.moving.validation;

import org.chees.clean.board.ChessBoard;
import org.chees.clean.engine.Move;
import org.chees.clean.piece.Piece;
import org.chees.clean.piece.PieceType;
import org.chees.clean.specification.Specification;

public class MoveValidationFactory {

    public Specification<Move> getMoveValidator(Piece piece, ChessBoard chessBoard) {
        return getValidatorByType(piece.pieceType(), chessBoard).And(new ValidationKingInCheck(chessBoard));
    }

    public Specification<Move> getValidatorByType(PieceType type, ChessBoard chessBoard) {
        return switch (type) {
            case BISHOP -> new ValidationNothingBetween(chessBoard);
            case PAWN -> new ValidationPawnMove(chessBoard);
            case KING -> new ValidationEmpty();
            case QUEEN -> new ValidationNothingBetween(chessBoard);
            case ROOK -> new ValidationNothingBetween(chessBoard);
            case KNIGHT -> new ValidationKnightJump();
        };
    }
}
