package org.chees.clean.board.position;

public enum PositionLetter {
    A(1),B(2),C(3),D(4),E(5),F(6),G(7),H(8);

    private final int value;

    PositionLetter(int value) {
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
