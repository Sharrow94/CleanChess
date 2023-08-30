package org.chees.clean.piece;

import org.chees.clean.board.position.Position;

public class Rook extends Piece{

    public Rook(PieceId id, Color color, Position position) {
        super(id, color, position);
    }

    @Override
    public Piece move(Position position) {
        return new Rook(id,color,position);
    }
}
