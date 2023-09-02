package org.chees.clean.moving.equation.implementation;

import org.chees.clean.board.position.Position;
import org.chees.clean.engine.Move;
import org.chees.clean.moving.equation.Equation;
import org.chees.clean.piece.Piece;

import java.util.List;

public class VerticalEquation implements Equation {

    private final int x;

    public VerticalEquation(int x) {
        this.x = x;
    }

    @Override
    public boolean test(Position position) {
        return x==position.letter().getValue();
    }

    @Override
    public List<Move> getAvailableMoves(Piece piece) {
        return null;
    }
}
