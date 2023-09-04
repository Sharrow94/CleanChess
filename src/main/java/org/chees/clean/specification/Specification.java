package org.chees.clean.specification;

public interface Specification<T> {
    boolean IsSatisfiedBy(T candidate);

    Specification<T> And(Specification<T> other);

    Specification<T> AndNot(Specification<T> other);

    Specification<T> Or(Specification<T> other);

    Specification<T> OrNot(Specification<T> other);

    Specification<T> Not();
}

