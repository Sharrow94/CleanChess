package org.chees.clean.moving.equation.implementation;

import org.chees.clean.board.position.Position;
import org.chees.clean.moving.equation.Equation;

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
