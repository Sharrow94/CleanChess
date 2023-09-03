package org.chees.clean.piece;

import org.chees.clean.board.position.Position;

public record Piece(PieceId id, Color color, Position position, PieceType pieceType) {

    public Piece {
        if (id == null || color == null || position == null) {
            throw new RuntimeException("Error during Piece creation");
        }
    }

}
