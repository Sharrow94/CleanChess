import org.chees.clean.board.Board;
import org.chees.clean.board.event.DomainEvent;
import org.chees.clean.board.event.MoveAcceptedEvent;
import org.chees.clean.board.event.MoveRejectedEvent;
import org.chees.clean.board.position.Position;
import org.chees.clean.board.position.PositionLetter;
import org.chees.clean.piece.PieceId;
import org.chees.clean.piece.Rook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {

    BoardSetupProvider boardSetupProvider=new BoardSetupProvider();

    @Test
    public void test_rook_can_move(){
        //given
        Board board=new Board(boardSetupProvider.getPiecesForKnightCorrectMove());
        //when
        DomainEvent domainEvent = board.processMove(new PieceId("1"), new Position(PositionLetter.C, 3));
        //then
        Assertions.assertTrue(domainEvent instanceof MoveAcceptedEvent);
    }
}
