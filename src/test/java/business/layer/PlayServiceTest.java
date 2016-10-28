package business.layer;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
/**
 * Created by Hrafnkell on 26/10/2016.
 */
public class PlayServiceTest
{
    PlayService playServiceTest = new PlayService();

    @Test
    public void testArraySize()
    {
        assertEquals(9, playServiceTest.getSize());
    }

    @Test
    public void testNextInput() {
        assertEquals("1", playServiceTest.getNext(0));
        assertEquals("5", playServiceTest.getNext(4));
    }

    @Test
    public void testResultsForPlayerOneWinHorizontal(){
        playServiceTest.board[0] = "X";
        playServiceTest.board[8] = "O";
        playServiceTest.board[1] = "X";
        playServiceTest.board[6] = "O";
        playServiceTest.board[2] = "X";
        assertEquals(1, playServiceTest.results());
    }
    @Test
    public void testResults9TurnsDraw() {
        playServiceTest.board[1] = "X";
        playServiceTest.board[0] = "O";
        playServiceTest.board[4] = "X";
        playServiceTest.board[2] = "O";
        playServiceTest.board[5] = "X";
        playServiceTest.board[3] = "O";
        playServiceTest.board[6] = "X";
        playServiceTest.board[7] = "O";
        playServiceTest.board[8] = "X";
        assertEquals(0, playServiceTest.results());
    }
    @Test
    public void testResultsForPlayerTwoWinCross(){
        playServiceTest.board[1] = "X";
        playServiceTest.board[0] = "O";
        playServiceTest.board[2] = "X";
        playServiceTest.board[4] = "O";
        playServiceTest.board[5] = "X";
        playServiceTest.board[8] = "O";
        playServiceTest.togglePlayer();
        assertEquals(1, playServiceTest.results());
    }
    /*@Test

    public void testResultsForPlayerOneWinVertical(){
        playServiceTest.board[1] = "X";
        playServiceTest.board[0] = "O";
        playServiceTest.board[4] = "X";
        playServiceTest.board[3] = "O";
        playServiceTest.board[7] = "X";
        assertEquals(1, playServiceTest.results());
    }*/
    /*
    @Test
    public void testInvalidPlayerChoiceInput() throws Exception {
        assertEquals(false, playServiceTest.validatePlayerInput(13));
    }

    @Test
    public void testValidPlayerChoiceInput() throws Exception {
        assertEquals(true, playServiceTest.validatePlayerInput(5));
    }*/
}
