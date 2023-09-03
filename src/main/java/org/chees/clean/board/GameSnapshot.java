package org.chees.clean.board;

public class GameSnapshot {

    public static GameSnapshot of(ChessBoard chessBoard) {
        return new GameSnapshot();
    }
}
