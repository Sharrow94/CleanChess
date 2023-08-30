import org.chees.clean.board.position.Position;
import org.chees.clean.piece.Piece;
import org.chees.clean.piece.PieceId;

import java.util.List;

import static org.chees.clean.board.position.PositionLetter.E;
import static org.chees.clean.piece.Color.WHITE;
import static org.chees.clean.piece.PieceType.KNIGHT;

public class BoardSetupProvider {

    public List<Piece> getPiecesForKnightCorrectMove() {
        return List.of(new Piece(new PieceId("1"), WHITE, new Position(E, 4), KNIGHT));
    }
}
