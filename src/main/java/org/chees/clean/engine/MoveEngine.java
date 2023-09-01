package org.chees.clean.engine;

import org.chees.clean.board.ChessBoard;
import org.chees.clean.piece.Color;

import java.util.List;

public interface MoveEngine {

    List<Move> getAllLegalMoves(ChessBoard board, Color color);
}
