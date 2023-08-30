package org.chees.clean.board;

import org.chees.clean.board.event.DomainEvent;
import org.chees.clean.board.event.GameStartedEvent;
import org.chees.clean.board.event.MoveAcceptedEvent;
import org.chees.clean.board.event.MoveRejectedEvent;
import org.chees.clean.board.position.Position;
import org.chees.clean.moving.MoveStrategy;
import org.chees.clean.moving.MoveStrategyFactoryImpl;
import org.chees.clean.moving.equation.Equation;
import org.chees.clean.moving.specification.SpecificationFactory;
import org.chees.clean.piece.Piece;
import org.chees.clean.piece.PieceFactory;
import org.chees.clean.piece.PieceId;

import java.util.List;

public class Board {

    private final SpecificationFactory specificationFactory;

    private final MoveStrategyFactoryImpl moveStrategyFactoryImpl;

    private final PieceFactory pieceFactory;

    private final List<Piece> pieces;


    public Board(SpecificationFactory specificationFactory, MoveStrategyFactoryImpl moveStrategyFactoryImpl, PieceFactory pieceFactory, List<Piece> pieces) {
        this.specificationFactory = specificationFactory;
        this.moveStrategyFactoryImpl = moveStrategyFactoryImpl;
        this.pieceFactory = pieceFactory;
        this.pieces = pieces;
    }

    public DomainEvent startGame() {
        pieceFactory.putPiecesOn(this);
        return new GameStartedEvent();
    }

    public DomainEvent processMove(PieceId id, Position position) {
        GameSnapshot snapshot=createSnapshot();
        Piece piece = pieces.stream().filter(figure -> figure.id().equals(id)).findAny().orElseThrow();
        MoveStrategy moveStrategy = moveStrategyFactoryImpl.getMoveStrategy(piece.pieceType());
        List<Equation> movementEquations = moveStrategy.getMovementEquations(piece);
        movementEquations.forEach(equation -> equation.test(position));
        return new MoveAcceptedEvent();
    }

    private GameSnapshot createSnapshot() {
        return null;
    }
}
