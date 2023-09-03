package org.chees.clean.engine;

import org.chees.clean.board.position.Position;

public record Move(Position from, Position to) {

    public Move {
        if (from == null || to == null) {
            throw new RuntimeException();
        }
    }
}
