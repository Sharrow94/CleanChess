package org.chees.clean.moving.validation;

import org.chees.clean.board.position.Position;
import org.chees.clean.engine.Move;


public class ValidationKnightJump implements MoveValidation {

    @Override
    public boolean test(Move move) {
        Position from = move.from();
        Position to = move.to();
        int deltaX = Math.abs(from.letter().getValue() - to.letter().getValue());
        int deltaY = Math.abs(from.number() - to.number());
        return deltaX * deltaY == 2;
    }
}
