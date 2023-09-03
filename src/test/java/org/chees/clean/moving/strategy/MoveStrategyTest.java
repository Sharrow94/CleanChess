package org.chees.clean.moving.strategy;

import org.chees.clean.board.position.Position;
import org.chees.clean.board.position.PositionLetter;
import org.chees.clean.engine.Move;
import org.chees.clean.piece.Color;
import org.chees.clean.piece.Piece;
import org.chees.clean.piece.PieceId;
import org.chees.clean.piece.PieceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MoveStrategyTest {

    @Test
    void knightMoveStrategy() {
        //given
        MoveStrategy moveStrategy = MoveStrategy.knightMoveStrategy();
        Position currentPosition = new Position(PositionLetter.E, 4);
        Piece piece = new Piece(new PieceId("1"), Color.WHITE, currentPosition, PieceType.KNIGHT);
        //when //then
        List<Move> moveList = moveStrategy.getAvailableMoves(piece);
        //then
        Assertions.assertTrue(moveList.contains(new Move(currentPosition, new Position(PositionLetter.D, 6))));
        Assertions.assertTrue(moveList.contains(new Move(currentPosition, new Position(PositionLetter.F, 6))));
        Assertions.assertTrue(moveList.contains(new Move(currentPosition, new Position(PositionLetter.D, 2))));
        Assertions.assertTrue(moveList.contains(new Move(currentPosition, new Position(PositionLetter.F, 2))));
        Assertions.assertTrue(moveList.contains(new Move(currentPosition, new Position(PositionLetter.C, 5))));
        Assertions.assertTrue(moveList.contains(new Move(currentPosition, new Position(PositionLetter.G, 5))));
        Assertions.assertTrue(moveList.contains(new Move(currentPosition, new Position(PositionLetter.C, 3))));
        Assertions.assertTrue(moveList.contains(new Move(currentPosition, new Position(PositionLetter.G, 3))));
    }

    @Test
    void pawnMoveStrategy() {
    }

    @Test
    void queenMoveStrategy() {
    }

    @Test
    void rookMoveStrategy() {
    }

    @Test
    void bishopMoveStrategy() {
    }

    @Test
    void kingMoveStrategy() {
    }

    @Test
    void getEquations() {
    }
}