package org.chees.clean.moving;

import java.math.BigDecimal;

/**
 * Mathematical formula for moving pieces
 */

public  class Equation {

    private final double a;
    private final double b;

    protected Equation(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public String toString() {
        return "Equation{y="+a+"x+"+b+"}";
    }
}
