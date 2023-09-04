package org.chees.clean.moving.validation;

import org.chees.clean.board.position.Position;
import org.chees.clean.engine.Move;
import org.chees.clean.specification.composite.CompositeSpecification;


public class ValidationKnightJump extends CompositeSpecification<Move> {

    @Override
    public boolean IsSatisfiedBy(Move candidate) {
        Position from = candidate.from();
        Position to = candidate.to();
        int deltaX = Math.abs(from.letter().getValue() - to.letter().getValue());
        int deltaY = Math.abs(from.number() - to.number());
        return deltaX * deltaY == 2;
    }
}
