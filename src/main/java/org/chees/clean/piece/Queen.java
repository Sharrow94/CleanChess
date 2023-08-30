package org.chees.clean.piece;

import org.chees.clean.board.position.Position;

import java.util.UUID;

public class Queen extends Piece{
    protected Queen(PieceId id , Color color, Position position) {
        super(id,color, position);
    }

    @Override
    public Piece move(Position position) {
        return null;
    }
}
