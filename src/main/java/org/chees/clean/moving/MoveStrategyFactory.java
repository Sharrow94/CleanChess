package org.chees.clean.moving;

import org.chees.clean.moving.MoveStrategy;
import org.chees.clean.piece.PieceType;

public interface MoveStrategyFactory {

    public MoveStrategy getMoveStrategy(PieceType type);
}
