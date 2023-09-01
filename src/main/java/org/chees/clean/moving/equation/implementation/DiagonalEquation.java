package org.chees.clean.moving.equation.implementation;

import org.chees.clean.board.position.Position;
import org.chees.clean.moving.equation.Equation;

public class DiagonalEquation implements Equation {

    private final double a;

    private final double b;

    public DiagonalEquation(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean test(Position position) {
        return position.number()==a*position.letter().getValue()+b;
    }
}
