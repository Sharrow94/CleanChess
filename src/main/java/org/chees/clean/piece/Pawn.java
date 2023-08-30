package org.chees.clean.piece;

import org.chees.clean.board.position.Position;

import java.util.UUID;

public class Pawn extends Piece {

    private final boolean isFirstMove;

    public Pawn(PieceId id ,Color color, Position position) {
        super(id,color, position);
        this.isFirstMove = true;
    }

    private Pawn(PieceId id ,Color color, Position position, boolean isFirstMove) {
        super(id,color, position);
        this.isFirstMove = isFirstMove;
    }

    @Override
    public Piece move(Position position) {
        return isPromotion(position) ? new Queen(new PieceId(UUID.randomUUID().toString()),color, position) : new Pawn(id ,color, position, false);
    }

    private boolean isPromotion(Position position) {
        return position.number() == 8 && color == Color.WHITE || position.number() == 1 && color == Color.BLACK;
    }

    public boolean isFirstMove() {
        return isFirstMove;
    }
}
