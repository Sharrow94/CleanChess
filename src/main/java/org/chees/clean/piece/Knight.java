package org.chees.clean.piece;

import org.chees.clean.board.position.Position;

public class Knight extends Piece{
    public Knight(PieceId id, Color color, Position position) {
        super(id, color, position);
    }

    @Override
    public Piece move(Position position) {
        return new Knight(id,color,position);
    }
}
