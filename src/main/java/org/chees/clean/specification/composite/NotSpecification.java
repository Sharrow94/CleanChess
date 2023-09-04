package org.chees.clean.specification.composite;

import org.chees.clean.specification.Specification;

public class NotSpecification<T> extends CompositeSpecification<T> {
    Specification<T> other;

    public NotSpecification(Specification<T> other) {
        this.other = other;
    }

    @Override
    public boolean IsSatisfiedBy(T candidate) {
        return !other.IsSatisfiedBy(candidate);
    }
}
