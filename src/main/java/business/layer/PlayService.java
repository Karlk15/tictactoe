package business.layer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import ui.layer.Interface;

/**
 * Created by Hrafnkell on 26/10/2016.
 */
public class PlayService {
    public enum playerChar {
        X, O
    }

    private Interface mainInterface;
    private String[] board;
    private playerChar currentPlayer;
    private Player player1;
    private Player player2;

    public PlayService(String playerOneName, boolean isPlayerOneHuman, String playerTwoName, boolean isPlayerTwoHuman) {
        board = new String[9];
        currentPlayer = currentPlayer.X;
        player1 = new Player(playerOneName, 1, isPlayerOneHuman);
        player2 = new Player(playerTwoName, 2, isPlayerTwoHuman);
        for (int i = 0; i < 9; i++)
            board[i] = Integer.toString(i + 1);
    }

    public int getSize() {
        return 9;
    }

    public String getNext(int next) {
        return board[next];
    }

    public void playGame()
    {

    }

    public void OnePlayerGame(){
        do
        {
            PlayTurnComputer();
            PlayTurnHuman();
        }while (results() == -1);
    }

    public void TwoPlayerGame()
    {

    }

    public void PlayTurnHuman (){
        int input;
        do{
            input = mainInterface.getPlayerChoice();
        }while(!validatePlayerInput(input));
        /*
        To do rest of turn
         */
        int res = results();
    }

    public void PlayTurnComputer(){
        boolean cont = false;
        while (cont == false) {
            int i = ThreadLocalRandom.current().nextInt(0, 8 + 1);
            if (!board[i].equals(playerChar.O) || !board[i].equals(playerChar.X)){
                board[i] = currentPlayer.toString();
                cont = true;
                togglePlayer();
            }
        }
        int res = results();
    }
    // if current player wins, return 1
    // if game should go on, return -1
    // if game is a draw, return 0
    private int results() {

        int rowCount = 0;

        /*for (int m = 0; m < board.length; m++){
            if (board[m].equals(playerChar.O) || board[m].equals(playerChar.X)){
                rowCount++;
            }
        }
        if (rowCount == 9){
            return 0;
        }
        rowCount = 0;*/

        for (int i = 0; i < board.length; i++){
            if (rowCount % 3 == 0 && rowCount != 0) {
                return 1;
            }
            if ((i % 3) == 0) {
                rowCount = 0;
            }
            if (board[i].equals(currentPlayer.toString())){
                rowCount++;
            }
        }
        // needs further testing
        /*for (int j = 0; j < board.length; j+= 3){
            if (j >= 6 && j <= 8){
                j -= 5;
            }
            if (j % 3 == 0 ) {
                rowCount = 0;
            }
            if (rowCount % 3 == 0 && rowCount != 0){
                return 1;
            }
            if (board[j].equals(currentPlayer)){
                rowCount++;
            }
        }*/
        if (board[0].equals(currentPlayer) && board[4].equals(currentPlayer) && board[8].equals(currentPlayer)){
            return 1;
        }
        if (board[2].equals(currentPlayer) && board[4].equals(currentPlayer) && board[6].equals(currentPlayer)){
            return 1;
        }
        return -1;
    }

    protected boolean validatePlayerInput(int char_input){
        if(char_input < 1 || char_input > 9){
            return false;
        }
        else if(!board[char_input-1].equals(Integer.toString(char_input))){
            return false;
        }
        else{
            return true;
        }
    }

    private void togglePlayer() {

        if (currentPlayer == playerChar.X){
            currentPlayer = playerChar.O;
        }
    }
}