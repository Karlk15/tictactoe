package business.layer;

import ui.layer.Interface;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Hrafnkell on 26/10/2016.
 */
public class PlayService {
    private enum playerChar {
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
        mainInterface = new Interface();
        for (int i = 0; i < 9; i++)
            board[i] = Integer.toString(i + 1);
    }
    
    public void playGame()
    {
        mainInterface.printWelcomeMessage();
        mainInterface.printMainMenu();
        String getChoice;
        boolean checkChoice = true;
        do{
            getChoice = mainInterface.getMenuInput();
            if(getChoice.equals("1")){
                OnePlayerGame();
            }
            else if(getChoice.equals("2")){
                TwoPlayerGame();
            }
            else if(getChoice.equals("q")){
                checkChoice = false;
                //print thanks for playing!
            }
            else{
                mainInterface.printWrongInput();
            }
        }while(checkChoice);
    }

    public void OnePlayerGame(){
        mainInterface.printInsertName("1");
        player1 = new Player(mainInterface.getPlayerName(), 1, true);
        player2 = new Player("PC Principal", 2, false);
        int results = -1;
        mainInterface.displayBoard(board);
        do {
            PlayTurnHuman();
            results = results();
            if (results == 1 || results == 0){
                checkResults(results, player1);
                break;
            }
            mainInterface.displayBoard(board);
            togglePlayer();
            PlayTurnComputer();
            results = results();
            checkResults(results, player2);
            mainInterface.printComputerTurnFinished();
            mainInterface.displayBoard(board);
            togglePlayer();
        }while (results() == -1);
    }

    public void TwoPlayerGame(){
        mainInterface.printInsertName("1");
        player1 = new Player(mainInterface.getPlayerName(), 1, true);
        mainInterface.printInsertName("2");
        player2 = new Player(mainInterface.getPlayerName(), 2, true);
        int results = -1;
        mainInterface.displayBoard(board);
        do{
            mainInterface.displayBoard(board);
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
    }

    public void PlayTurnComputer(){
        boolean cont = false;
        while (cont == false) {
            int i = ThreadLocalRandom.current().nextInt(0, 8 + 1);
            if (!board[i].equals(playerChar.O.toString()) && !board[i].equals(playerChar.X.toString())){
                board[i] = currentPlayer.toString();
                cont = true;
            }
        }
    }

    public static void main(String[] args){
        PlayService ps = new PlayService();
        ps.playGame();
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
        else{
            currentPlayer = playerChar.X;
        }
    }

    protected void makeMove(int place){
        board[place - 1] = currentPlayer.toString();
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