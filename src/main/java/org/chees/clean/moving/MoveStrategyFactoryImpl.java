package org.chees.clean.moving;

import org.chees.clean.piece.PieceType;

public class MoveStrategyFactoryImpl implements MoveStrategyFactory{

    @Override
    public MoveStrategy getMoveStrategy(PieceType type) {
        return switch (type) {
            case BISHOP -> new BishopMoveStrategy();
            case PAWN -> new PawnMoveStrategy();
            case KING -> new KingMoveStrategy();
            case QUEEN -> new QueenMoveStrategy();
            case ROOK -> new RookMoveStrategy();
            case KNIGHT -> new KnightMoveStrategy();
            default -> throw new RuntimeException("No supported piece type!");
        };

    }
}
