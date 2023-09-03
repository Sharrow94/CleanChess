package org.chees.clean.moving.validation;

import org.chees.clean.board.ChessBoard;
import org.chees.clean.board.position.Position;
import org.chees.clean.engine.Move;
import org.chees.clean.piece.Piece;

public class ValidationNothingBetween implements MoveValidation {

    private final ChessBoard chessBoard;


    public ValidationNothingBetween(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public boolean test(Move move) {
        return chessBoard.pieces().stream().map(Piece::position).noneMatch(position -> isBetween(position, move));
    }

    public boolean isBetween(Position position, Move move) {
        Position from = move.from();
        Position to = move.to();
        double A = to.number() - from.number();
        double B = from.letter().getValue() - to.letter().getValue();
        double C = -(A * from.letter().getValue()) - (B * from.number());
        return A * position.letter().getValue() + B * position.number() + C == 0;
    }
}
