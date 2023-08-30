package org.chees.clean.moving.equation;

import org.chees.clean.board.position.Position;

public class VerticalEquation implements Equation {

    private final int x;

    public VerticalEquation(int x) {
        this.x = x;
    }

    @Override
    public boolean test(Position position) {
        return x==position.letter().getValue();
    }
}
