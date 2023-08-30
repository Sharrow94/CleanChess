package org.chees.clean.piece;

public enum Color {
    WHITE(1), BLACK(-1);

    private final int value;

    Color(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
