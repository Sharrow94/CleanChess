package org.chees.clean.moving;

import org.chees.clean.board.position.Position;
import org.chees.clean.piece.Piece;

import java.util.List;

public interface MoveStrategy <T extends Piece>{
    List<Equation> getMovementEquation(T piece);
}
