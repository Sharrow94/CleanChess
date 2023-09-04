package org.chees.clean.specification.composite;

import org.chees.clean.specification.Specification;

public abstract class CompositeSpecification<T> implements Specification<T> {
    public abstract boolean IsSatisfiedBy(T candidate);

    public Specification<T> And(Specification<T> other) {
        return new AndSpecification<T>(this, other);
    }

    public Specification<T> AndNot(Specification<T> other) {
        return new AndNotSpecification<T>(this, other);
    }

    public Specification<T> Or(Specification<T> other) {
        return new OrSpecification<T>(this, other);
    }

    public Specification<T> OrNot(Specification<T> other) {
        return new OrNotSpecification<T>(this, other);
    }

    public Specification<T> Not() {
        return new NotSpecification<T>(this);
    }
}
