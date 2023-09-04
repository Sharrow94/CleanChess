package org.chees.clean.specification.composite;

import java.util.function.Predicate;

public abstract class LinqSpecification<T> extends CompositeSpecification<T> {
    public abstract Predicate<T> AsPredicate();

    @Override
    public boolean IsSatisfiedBy(T candidate) {
        return AsPredicate().test(candidate);
    }
}
