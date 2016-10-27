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
    public void testNext()
    {
        assertEquals("1", playServiceTest.getNext(0));
        assertEquals("5", playServiceTest.getNext(4));
    }

}
