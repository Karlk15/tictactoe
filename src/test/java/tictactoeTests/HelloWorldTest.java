package tictactoeTests;


import org.junit.Test;
import tictactoe.HelloWorld;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lenovo on 25.10.2016.
 */
public class HelloWorldTest {

    @Test
    public void testHelloWorld() throws Exception{
        assertEquals("Hello World NIGUUUHHH", HelloWorld.hello());
    }
}
