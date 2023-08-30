package org.chees.clean.board.position;

public record Position(PositionLetter letter, int number)  {
    public Position{
        if (letter==null||number<1||number>8){
            throw new PositionCreatingException();
        }
    }
}
