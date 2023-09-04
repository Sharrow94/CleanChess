package org.chees.clean.specification.composite;

import org.chees.clean.specification.Specification;

public class OrSpecification<T> extends CompositeSpecification<T> {
    Specification<T> left;
    Specification<T> right;

    public OrSpecification(Specification<T> left, Specification<T> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean IsSatisfiedBy(T candidate) {
        return left.IsSatisfiedBy(candidate) || right.IsSatisfiedBy(candidate);
    }
}