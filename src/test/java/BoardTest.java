import org.chees.clean.board.Board;
import org.chees.clean.board.event.DomainEvent;
import org.chees.clean.board.event.MoveAcceptedEvent;
import org.chees.clean.board.position.Position;
import org.chees.clean.board.position.PositionLetter;
import org.chees.clean.moving.MoveStrategyFactoryImpl;
import org.chees.clean.moving.specification.SpecificationFactory;
import org.chees.clean.piece.PieceFactory;
import org.chees.clean.piece.PieceId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {

    private BoardSetupProvider boardSetupProvider=new BoardSetupProvider();
    private SpecificationFactory specificationFactory=new SpecificationFactory();
    private MoveStrategyFactoryImpl moveStrategyFactoryImpl =new MoveStrategyFactoryImpl();
    private PieceFactory pieceFactory=new PieceFactory();

    @Test
    public void test_rook_can_move(){
        //given
        Board board=new Board(specificationFactory, moveStrategyFactoryImpl, pieceFactory, boardSetupProvider.getPiecesForKnightCorrectMove());
        //when
        DomainEvent domainEvent = board.processMove(new PieceId("1"), new Position(PositionLetter.C, 3));
        //then
        Assertions.assertTrue(domainEvent instanceof MoveAcceptedEvent);
    }
}
