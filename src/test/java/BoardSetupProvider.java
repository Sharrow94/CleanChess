import org.chees.clean.board.position.Position;
import org.chees.clean.board.position.PositionLetter;
import org.chees.clean.piece.*;

import java.util.List;
import java.util.UUID;

public class BoardSetupProvider {

        public List<Piece> getPiecesForKnightCorrectMove(){
            return List.of(new Knight(new PieceId("1"), Color.WHITE,new Position(PositionLetter.E,4)));
        }
}
