package business.layer;

import ui.layer.Interface;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Hrafnkell on 26/10/2016.
 */
public class PlayService {

    protected enum playerChar {
        X, O
    }

    protected String[] board;
    protected playerChar currentPlayer;

    /**
        public constructor for PlayService
        initializes the board, sets currentplayer to X
        and creates a new interface
     */
    public PlayService() {
        board = new String[9];
        currentPlayer = playerChar.X;
        for (int i = 0; i < 9; i++)
            board[i] = Integer.toString(i + 1);
    }

    public void PlayTurn (int input){
        do{
            if(!validatePlayerInput(input)){
                // display to player he did a dumb thing
            }
        }while(!validatePlayerInput(input));
        makeMove(input);
        int results = results();
        if(currentPlayer == currentPlayer.X){
            checkResults(results);
        }
        else{
            checkResults(results);
        }
        togglePlayer();
    }

    public String[] getBoard(){
        return board;
    }

    public int getPlayer(){
        if(currentPlayer == playerChar.X){
            return 1;
        }
        else{
            return 2;
        }
    }

    /**
     * Checks whether the game is over or not and returns the results
     * @return 1 if the game is a win, 0 if it's a draw, -1 if the game isn't over
     */
    public int results() {

        int rowCount = 0;

        for (int m = 0; m < board.length; m++){
            if (board[m].equals(playerChar.O.toString()) || board[m].equals(playerChar.X.toString())){
                rowCount++;
            }
        }
        if (rowCount == 9){
            return 0;
        }
        rowCount = 0;

        for (int i = 0; i < board.length; i++){
            if (board[i].equals(currentPlayer.toString())){
                rowCount++;
            }
            if (rowCount % 3 == 0 && rowCount != 0) {
                return 1;
            }
            if (((i + 1) % 3) == 0 && i != 0) {
                rowCount = 0;
            }
        }
        rowCount = 0;

        for (int j = 0; j < board.length; j+= 3){
            if (board[j].equals(currentPlayer.toString())){
                rowCount++;
            }
            if (rowCount % 3 == 0 && rowCount != 0){
                return 1;
            }
            if (j >= 6 && j <= 7){
                j -= 8;
                rowCount = 0;
            }
        }
        if (board[0].equals(currentPlayer.toString()) && board[4].equals(currentPlayer.toString()) && board[8].equals(currentPlayer.toString())){
            return 1;
        }
        if (board[2].equals(currentPlayer.toString()) && board[4].equals(currentPlayer.toString()) && board[6].equals(currentPlayer.toString())){
            return 1;
        }
        return -1;
    }

    /**
     * validates the input taken from the player
     * @param char_input the input taken from the player
     * @return true if the input is a valid move, false if it isn't
     */
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

    /**
     * changes the player from X to O or vice versa
     */
    protected void togglePlayer() {

        if (currentPlayer == playerChar.X){
            currentPlayer = playerChar.O;
        }
        else{
            currentPlayer = playerChar.X;
        }
    }

    /**
     * makes the move the player choose
     * @param place the placement to be made
     */
    protected void makeMove(int place){
        board[place - 1] = currentPlayer.toString();
    }

    /**
     * Checks if the result is a win and calls the interface to print
     * necessary results
     * @param res was the result a win, draw or a loss
     */
    public int checkResults(int res){
        if(res == -1){

        }
        else if(res == 1){
            restartGame();
            return 1;

        }
        restartGame();
        return 0;
    }

    public void restartGame(){
        PlayService newPlay = new PlayService();
        newPlay.PlayTurn(1); // needs to take input from player
    }
}