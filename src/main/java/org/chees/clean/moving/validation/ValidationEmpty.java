package org.chees.clean.moving.validation;

import org.chees.clean.engine.Move;
import org.chees.clean.specification.composite.CompositeSpecification;

public class ValidationEmpty extends CompositeSpecification<Move> {
    @Override
    public boolean IsSatisfiedBy(Move candidate) {
        return true;
    }
}
