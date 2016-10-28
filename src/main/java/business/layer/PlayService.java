package business.layer;

import ui.layer.Interface;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Hrafnkell on 26/10/2016.
 */
public class PlayService {
    public enum playerChar {
        X, O
    }

    private Interface mainInterface;
    protected String[] board;
    private playerChar currentPlayer;
    private Player player1;
    private Player player2;

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

    public void playGame()
    {

    }

    public void OnePlayerGame(){
        do
        {
            int input = mainInterface.getPlayerChoice();
            validatePlayerInput(input);
            PlayTurnComputer();
            PlayTurnHuman();
        }while (results() == -1);
    }

    public void TwoPlayerGame(){
        for(int i = 0; i < 2; i++){
            //gets the name for both players
            //need to implement a function in interface to print "Enter name for player i"
        }
        player1 = new Player("Name1 gotten from interface", 1, true);
        player2 = new Player("Name2 gotten from interface", 2, true);
        int results = -1;
        do{
            PlayTurnHuman();
            results = results();
            if(currentPlayer == currentPlayer.X){
                checkResults(results, player1);
            }
            else{
                checkResults(results, player2);
            }
            togglePlayer();
        }while(results == -1);
    }

    public void PlayTurnHuman (){
        int input;
        do{
            input = mainInterface.getPlayerChoice();
            if(!validatePlayerInput(input)){
                mainInterface.printWrongInput();
            }
        }while(!validatePlayerInput(input));
        makeMove(input);
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
    protected int results() {

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
            if ((i % 3) == 0 && i != 0) {
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

    protected void togglePlayer() {

        if (currentPlayer == playerChar.X){
            currentPlayer = playerChar.O;
        }
    }

    protected void makeMove(int place){
        board[place] = currentPlayer.toString();
    }

    protected void checkResults(int res, Player currentPlayer){
        if(res == -1){

        }
        else if(res == 1){
            mainInterface.printResults(currentPlayer.getPlayerName());
            String input = mainInterface.printContinuePlaying();
            if(input == "y"){
                playGame();
            }
        }
        else if(res == 0){
            mainInterface.printDraw();
            String input = mainInterface.printContinuePlaying();;
            while(input != "n"){
                input = mainInterface.getMenuInput();
                if(input == "y"){
                    playGame();
                    break;
                }
                else{
                    mainInterface.printWrongInput();
                }
            }
        }
    }
}