package business.layer;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
/**
 * Created by Hrafnkell on 26/10/2016.
 */
public class PlayServiceTest
{
    PlayService playServiceTest = new PlayService("Bob Barker", true, "Billy Bitter", true);

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
    public void testPlayTurnHuman() throws Exception {
        assertEquals(-1, playServiceTest.PlayTurnHuman(4));
    }

    @Test
    public void testPlay4TurnsHuman() throws Exception {
        playServiceTest.PlayTurnHuman(1);
        playServiceTest.PlayTurnHuman(2);
        playServiceTest.PlayTurnHuman(4);
        assertEquals(-1, playServiceTest.PlayTurnHuman(9));

    }

    @Test
    public void testPlay5TurnsPlayer1Win() throws Exception {
        playServiceTest.PlayTurnHuman(1);
        playServiceTest.PlayTurnHuman(4);
        playServiceTest.PlayTurnHuman(2);
        playServiceTest.PlayTurnHuman(6);
        assertEquals(1, playServiceTest.PlayTurnHuman(3));
    }

    /*@Test
    public void testPlay9TurnsDraw() throws Exception {
        playServiceTest.PlayTurnHuman(2);
        playServiceTest.PlayTurnHuman(1);
        playServiceTest.PlayTurnHuman(5);
        playServiceTest.PlayTurnHuman(3);
        playServiceTest.PlayTurnHuman(6);
        playServiceTest.PlayTurnHuman(4);
        playServiceTest.PlayTurnHuman(7);
        playServiceTest.PlayTurnHuman(8);
        assertEquals(0, playServiceTest.PlayTurnHuman(9));
    }*/

}
