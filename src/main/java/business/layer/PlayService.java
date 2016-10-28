package business.layer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Hrafnkell on 26/10/2016.
 */
public class PlayService {
    public enum playerChar {
        X, O
    }

    private String[] board;
    private playerChar currentPlayer;

    public PlayService() {
        board = new String[9];
        currentPlayer = currentPlayer.X;
        for (int i = 0; i < 9; i++)
            board[i] = Integer.toString(i + 1);
    }

    public int getSize() {
        return 9;
    }

    public String getNext(int next) {
        return board[next];
    }

    public int PlayTurn(char input) {
        return 0;
    }

    private void results() {

        int rowCount = 0;

        for (int i = 0; i < board.length; i++){
            if (rowCount % 3 == 0){
                // win
            }
            if (i + 1 % 3 == 0) {
                rowCount = 0;
            }
            if (board[i].equals(currentPlayer)){
                rowCount++;
            }
        }
        for (int j = 0; j < board.length; j+= 3){
            if (j >= 6 && j <= 8){
                j -= 5;
            }
            if (rowCount % 3 == 0){
                // win
            }
            if (j % 3 == 0) {
                rowCount = 0;
            }
            if (board[j].equals(currentPlayer)){
                rowCount++;
            }
        }
        if (board[0].equals(currentPlayer) && board[4].equals(currentPlayer) && board[8].equals(currentPlayer)){
            // win
        }
        if (board[2].equals(currentPlayer) && board[4].equals(currentPlayer) && board[6].equals(currentPlayer)){
            // win
        }
    }

    private void togglePlayer() {

        if (currentPlayer == playerChar.X){
            currentPlayer = playerChar.O;
        }
    }
}