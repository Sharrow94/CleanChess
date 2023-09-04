package org.chees.clean.engine;

import org.chees.clean.board.ChessBoard;
import org.chees.clean.moving.strategy.MoveStrategy;
import org.chees.clean.moving.strategy.MoveStrategyFactory;
import org.chees.clean.moving.validation.MoveValidationFactory;
import org.chees.clean.piece.Color;
import org.chees.clean.piece.Piece;
import org.chees.clean.specification.Specification;

import java.util.List;
import java.util.stream.Stream;

public class MoveEngineImpl implements MoveEngine {

    private final MoveStrategyFactory moveStrategyFactory;

    private final MoveValidationFactory moveValidationFactory;

    public MoveEngineImpl(MoveStrategyFactory moveStrategyFactory, MoveValidationFactory moveValidationFactory) {
        this.moveStrategyFactory = moveStrategyFactory;
        this.moveValidationFactory = moveValidationFactory;
    }

    @Override
    public List<Move> getAllLegalMoves(ChessBoard board, Color color) {
        return board.pieces().stream().filter(piece -> piece.color().equals(color))
                .flatMap(piece -> getLegalMovesFor(piece, board)).toList();
    }

    private Stream<Move> getLegalMovesFor(Piece piece, ChessBoard board) {
        MoveStrategy moveStrategy = moveStrategyFactory.getMoveStrategy(piece.pieceType());
        List<Move> moveList = moveStrategy.getAvailableMoves(piece);
        Specification<Move> moveValidator = moveValidationFactory.getMoveValidator(piece, board);
        return moveList.stream().filter(moveValidator::IsSatisfiedBy);
    }
}
