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
        PlayService playServiceTest1 = new PlayService();
        playServiceTest1.board[0] = "X";
        playServiceTest1.board[8] = "O";
        playServiceTest1.board[1] = "X";
        playServiceTest1.board[6] = "O";
        playServiceTest1.board[2] = "X";
        assertEquals(1, playServiceTest1.results());
    }
    @Test
    public void testResults9TurnsDraw() {
        PlayService playServiceTest2 = new PlayService();
        playServiceTest2.board[1] = "X";
        playServiceTest2.board[0] = "O";
        playServiceTest2.board[4] = "X";
        playServiceTest2.board[2] = "O";
        playServiceTest2.board[5] = "X";
        playServiceTest2.board[3] = "O";
        playServiceTest2.board[6] = "X";
        playServiceTest2.board[7] = "O";
        playServiceTest2.board[8] = "X";
        assertEquals(0, playServiceTest2.results());
    }
    @Test
    public void testResultsForPlayerTwoWinCross(){
        PlayService playServiceTest4 = new PlayService();
        playServiceTest4.board[1] = "X";
        playServiceTest4.board[0] = "O";
        playServiceTest4.board[2] = "X";
        playServiceTest4.board[4] = "O";
        playServiceTest4.board[5] = "X";
        playServiceTest4.board[8] = "O";
        playServiceTest4.togglePlayer();
        assertEquals(1, playServiceTest4.results());
    }
    @Test
    public void testResultsForPlayerOneWinVertical(){
        PlayService playServiceTest3 = new PlayService();
        playServiceTest3.board[1] = "X";
        playServiceTest3.board[0] = "O";
        playServiceTest3.board[4] = "X";
        playServiceTest3.board[3] = "O";
        playServiceTest3.board[7] = "X";
        assertEquals(1, playServiceTest3.results());
    }
}
