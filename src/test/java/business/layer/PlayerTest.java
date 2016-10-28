package business.layer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lenovo on 28.10.2016.
 */
public class PlayerTest {
    @Test
    public void testHumanPlayerGetFunctions(){
        Player humanPlayerTest = new Player("Karl Óli Arnars", 1, true);
        assertEquals("Karl Óli Arnars", humanPlayerTest.getPlayerName());
        assertEquals(1, humanPlayerTest.getPlayerNumber());
        assertEquals(true, humanPlayerTest.isHumanPlayer());
    }
    @Test
    public void testComputerPlayerGetFunctions(){
        Player computerPlayerTest = new Player("", 2, false);
        assertEquals("Computer McConaughey", computerPlayerTest.getPlayerName());
        assertEquals(2, computerPlayerTest.getPlayerNumber());
        assertEquals(false, computerPlayerTest.isHumanPlayer());
    }
}
