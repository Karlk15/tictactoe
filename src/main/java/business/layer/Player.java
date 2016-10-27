package business.layer;
import java.util.Scanner;
/**
 * Created by oliolafsson on 27/10/16.
 */
public class Player
{
    private String playerName;
    private int playerNumber;
    private boolean humanPlayer;


    public Player(String name, int number, boolean isHuman)
    {
        if(!isHuman)
        {
            playerName = "Computer McConaughey";
        }
        else
        {
            this.playerName = name;
        }
        this.playerNumber = number;
        humanPlayer = isHuman;
    }

    public String getPlayerName()
    {
        return playerName;
    }

    public int getPlayerNumber()
    {
        return playerNumber;
    }

    public boolean isHumanPlayer()
    {
        return humanPlayer;
    }
}
