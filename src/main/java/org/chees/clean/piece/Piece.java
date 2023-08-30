package org.chees.clean.piece;

import org.chees.clean.board.position.Position;

public abstract class Piece {

    final PieceId id;

    final Color color;

    final Position position;

    protected Piece(PieceId id,Color color, Position position) {
        this.id=id;
        this.color = color;
        this.position = position;
    }

    public abstract Piece move(Position position);

    public PieceId getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }
}
