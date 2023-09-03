package org.chees.clean.board;

import org.chees.clean.event.DomainEvent;
import org.chees.clean.piece.Piece;

import java.util.List;

public record ChessBoard(List<Piece> pieces, List<DomainEvent> events) {

    public DomainEvent getLastEvent() {
        return events.get(events.size() - 1);
    }
}
