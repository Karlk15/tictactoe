package business.layer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Hrafnkell on 26/10/2016.
 */
public class PlayService
{
    private ArrayList<String>board;

    public PlayService()
    {
        board = new ArrayList<>();
        for(int i = 0; i < 9; i++)
            board.add(Integer.toString(i+1));
    }

    public int getSize()
    {
        return board.size();
    }

    public String getNext(int next)
    {
        return board.get(next);
    }

    public int PlayTurn()
    {
        return 0;
    }

    private void results(){

        
    }

    private void togglePlayer(){


    }


}
