package business.layer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Hrafnkell on 26/10/2016.
 */
public class PlayService
{
    public enum playerChar {
        X, O
    }

    private String[] board;
    private playerChar currentPlayer;

    public PlayService()
    {
        board = new String[9];
        currentPlayer = currentPlayer.X;
        for(int i = 0; i < 9; i++)
            board[i] = Integer.toString(i+1);
    }

    public int getSize()
    {
        return 9;
    }

    public String getNext(int next)
    {
        return board[next];
    }

    public int PlayTurn(char input)
    {
        return 0;
    }
<<<<<<< HEAD

    private void results(){

        
    }

    private void togglePlayer(){


    }


=======
>>>>>>> efc71e12161cbb6f1ab19448ee7b5775e631dd2a
}
