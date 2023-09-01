package org.chees.clean.moving.strategy;

import org.chees.clean.piece.PieceType;

public interface MoveStrategyFactory {

    MoveStrategy getMoveStrategy(PieceType type);
}
