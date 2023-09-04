package org.chees.clean.moving.strategy;

import org.chees.clean.piece.PieceType;

public class MoveStrategyFactoryImpl implements MoveStrategyFactory {

    @Override
    public MoveStrategy getMoveStrategy(PieceType type) {
        return switch (type) {
            case BISHOP -> MoveStrategy.bishopMoveStrategy();
            case PAWN -> MoveStrategy.pawnMoveStrategy();
            case KING -> MoveStrategy.kingMoveStrategy();
            case QUEEN -> MoveStrategy.queenMoveStrategy();
            case ROOK -> MoveStrategy.rookMoveStrategy();
            case KNIGHT -> MoveStrategy.knightMoveStrategy();
        };
    }
}
