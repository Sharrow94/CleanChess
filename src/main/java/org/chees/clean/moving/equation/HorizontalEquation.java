package org.chees.clean.moving.equation;

import org.chees.clean.board.position.Position;

public class HorizontalEquation implements Equation {

    private final int y;

    public HorizontalEquation(int y) {
        this.y = y;
    }

    @Override
    public boolean test(Position position) {
        return y == position.number();
    }
}
