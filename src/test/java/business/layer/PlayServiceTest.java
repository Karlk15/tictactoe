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
    @Test
    public void testValidatePlayerInputWrongInput(){
        assertEquals(false, playServiceTest.validatePlayerInput(99));
        assertEquals(false, playServiceTest.validatePlayerInput(-345));
    }
    @Test
    public void testValidatePlayerInputCorrectInput(){
        assertEquals(true, playServiceTest.validatePlayerInput(3));
        assertEquals(true, playServiceTest.validatePlayerInput(9));
    }

    @Test
    public void testTogglePlayerCorrect(){
        playServiceTest.togglePlayer();
        assertEquals(PlayService.playerChar.O, playServiceTest.currentPlayer);
    }

    @Test
    public void testMakeFourMoves(){
        playServiceTest.makeMove(3);
        playServiceTest.togglePlayer();
        playServiceTest.makeMove(5);
        playServiceTest.togglePlayer();
        playServiceTest.makeMove(1);
        playServiceTest.togglePlayer();
        playServiceTest.makeMove(8);
        assertEquals("X", playServiceTest.board[2]);
        assertEquals("O", playServiceTest.board[4]);
        assertEquals("X", playServiceTest.board[0]);
        assertEquals("O", playServiceTest.board[7]);
    }
}
