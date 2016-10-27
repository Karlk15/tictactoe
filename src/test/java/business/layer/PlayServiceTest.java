package business.layer;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
/**
 * Created by Hrafnkell on 26/10/2016.
 */
public class PlayServiceTest {

    @Test
    public void testHelloWorld()
    {
        assertEquals("Hello World", PlayService.TravisTester());
    }

    @Test
    public void travisFailedTest()
    {
        assertEquals("Expected Text", PlayService.travisFailedTest());
    }
}
