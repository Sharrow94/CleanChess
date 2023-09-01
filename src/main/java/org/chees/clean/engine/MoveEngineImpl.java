package org.chees.clean.engine;

import org.chees.clean.board.ChessBoard;
import org.chees.clean.moving.equation.Equation;
import org.chees.clean.moving.strategy.MoveStrategy;
import org.chees.clean.moving.strategy.MoveStrategyFactory;
import org.chees.clean.piece.Color;
import org.chees.clean.piece.Piece;

import java.util.List;
import java.util.stream.Stream;

public class MoveEngineImpl implements MoveEngine {

    private final MoveStrategyFactory moveStrategyFactory;

    public MoveEngineImpl(MoveStrategyFactory moveStrategyFactory) {
        this.moveStrategyFactory = moveStrategyFactory;
    }

    @Override
    public List<Move> getAllLegalMoves(ChessBoard board, Color color) {
        return board.pieces().stream().filter(piece -> piece.color().equals(color))
                .flatMap(piece -> getLegalMovesFor(piece, board)).toList();
    }

    private Stream<Move> getLegalMovesFor(Piece piece, ChessBoard board) {
        MoveStrategy moveStrategy = moveStrategyFactory.getMoveStrategy(piece.pieceType());
        List<Equation> equationList = moveStrategy.getEquations(piece);

        return Stream.of();
    }
}
