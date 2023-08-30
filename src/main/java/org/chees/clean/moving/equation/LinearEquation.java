package org.chees.clean.moving.equation;

import org.chees.clean.board.position.Position;

public class LinearEquation implements Equation{

    private final double a;

    private final double b;

    public LinearEquation(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean test(Position position) {
        return position.number()==a*position.letter().getValue()+b;
    }
}
