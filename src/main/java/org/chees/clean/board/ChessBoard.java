package org.chees.clean.board;

import org.chees.clean.board.event.DomainEvent;
import org.chees.clean.piece.Piece;

import java.util.List;

public record ChessBoard(List<Piece> pieces, List<DomainEvent>events) {

}
