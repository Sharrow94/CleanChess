package org.chees.clean.board;

import org.chees.clean.board.event.DomainEvent;
import org.chees.clean.board.event.GameStartedEvent;
import org.chees.clean.board.position.Position;
import org.chees.clean.moving.specification.SpecificationFactory;
import org.chees.clean.piece.Piece;
import org.chees.clean.piece.PieceFactory;
import org.chees.clean.piece.PieceId;

import java.util.List;

public class Board {

    private SpecificationFactory specificationFactory;

    private PieceFactory pieceFactory;

    private final List<Piece>pieces;


    public Board(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public  DomainEvent startGame(){
        pieceFactory.putPiecesOn(this);
            return new GameStartedEvent();
    }

    public DomainEvent processMove(PieceId id, Position position){
        Piece piece = pieces.stream().filter(figure -> figure.getId().equals(id)).findAny()
                .orElse(null);


        return null;
    }
}
