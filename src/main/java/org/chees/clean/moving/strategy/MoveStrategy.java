package org.chees.clean.moving.strategy;

import org.chees.clean.moving.equation.Equation;
import org.chees.clean.piece.Piece;

import java.util.List;

public interface MoveStrategy {

    List<Equation> getEquations(Piece piece);
}

