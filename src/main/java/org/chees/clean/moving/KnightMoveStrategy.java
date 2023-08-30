package org.chees.clean.moving;

import org.chees.clean.board.position.Position;
import org.chees.clean.piece.Knight;

import java.util.List;


public class KnightMoveStrategy implements MoveStrategy<Knight> {

    @Override
    public List<Equation> getMovementEquation(Knight piece) {
        Position position = piece.getPosition();
        double a = 0.5;
        double y = position.number();
        double halfX = a * position.letter().getValue();
        return List.of(new Equation(a, y - halfX), new Equation(-a, y + halfX));
    }
}