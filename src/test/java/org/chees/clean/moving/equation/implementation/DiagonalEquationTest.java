package org.chees.clean.moving.equation.implementation;

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

class DiagonalEquationTest {

    @Test
    public void test_knightEquation_true() {
        //given
        DiagonalEquation diagonalEquation = new DiagonalEquation(0.5, 0);
        //when //then
        Position currentPosition = new Position(PositionLetter.E, 4);
        List<Move> availableMoves = diagonalEquation.getAvailableMoves(new Piece(new PieceId("1"), Color.WHITE, currentPosition, PieceType.KNIGHT));
//        Assertions.assertEquals(new Move(currentPosition, new Position()));
    }

    @Test
    public void test_knightEquation_false() {
        //given
        DiagonalEquation diagonalEquation = new DiagonalEquation(0.5, 0);
        //when //then
        Assertions.assertFalse(diagonalEquation.test(new Position(PositionLetter.D, 3)));
    }

    @Test
    public void test_knightEquation_false2() {
        //given
        DiagonalEquation diagonalEquation = new DiagonalEquation(0.5, 0);
        //when //then
        Assertions.assertFalse(diagonalEquation.test(new Position(PositionLetter.B, 2)));
    }

}