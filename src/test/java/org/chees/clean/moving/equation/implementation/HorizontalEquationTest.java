package org.chees.clean.moving.equation.implementation;

import org.chees.clean.board.position.Position;
import org.chees.clean.board.position.PositionLetter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HorizontalEquationTest {

    @Test
    void test_test_passed() {
        //given
        HorizontalEquation horizontalEquation = new HorizontalEquation(3);
        //when //then
        Assertions.assertTrue(horizontalEquation.test(new Position(PositionLetter.A, 3)));
    }

    @Test
    void test_test_not_passed() {
        //given
        HorizontalEquation horizontalEquation = new HorizontalEquation(3);
        //when //then
        Assertions.assertFalse(horizontalEquation.test(new Position(PositionLetter.A, 1)));
    }

    @Test
    void getAvailableMoves() {
    }
}