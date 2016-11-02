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

    private Interface mainInterface;
    protected String[] board;
    protected playerChar currentPlayer;
    private Player player1;
    private Player player2;

    public static void main(String[] args){
        PlayService ps = new PlayService();
        ps.playGame();
    }

    /**
        public constructor for PlayService
        initializes the board, sets currentplayer to X
        and creates a new interface
     */
    public PlayService() {
        board = new String[9];
        currentPlayer = currentPlayer.X;
        mainInterface = new Interface();
        for (int i = 0; i < 9; i++)
            board[i] = Integer.toString(i + 1);
    }

    /**
     * The main function for this TicTacToe program
     * Calls the needed interface functions to print the main menu
     * and initializes a new game based on the player choice
     */
    public void playGame()
    {
        mainInterface.printWelcomeMessage();
        mainInterface.printMainMenu();
        String getChoice;
        boolean checkChoice = true;
        getChoice = mainInterface.getMenuInput();
        while (checkChoice == true){
            if (getChoice.equals("q")){
                checkChoice = false;  
                System.exit(0);   
            }
            else if(getChoice.equals("2")){
                TwoPlayerGame();
            }
            else if(getChoice.equals("1")){
                OnePlayerGame();
            }
            else{
                mainInterface.printWrongInput();
                getChoice = mainInterface.getMenuInput();
            }
        }
    }

    /**
     * The main function for a one player game.
     * Plays through one human turn and automates one computer turn
     * Also let's the human player choose his name
     */
    public void OnePlayerGame(){
        mainInterface.printInsertName("1");
        player1 = new Player(mainInterface.getPlayerName(), 1, true);
        player2 = new Player("", 2, false);
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

    /**
     * The main function for a two player game
     * Plays through two human turns
     * Also lets the two players choose their name
     */
    public void TwoPlayerGame(){
        mainInterface.printInsertName("1");
        player1 = new Player(mainInterface.getPlayerName(), 1, true);
        mainInterface.printInsertName("2");
        player2 = new Player(mainInterface.getPlayerName(), 2, true);
        int results = -1;
        mainInterface.displayBoard(board);
        do{
            PlayTurnHuman();
            results = results();
            if(currentPlayer == currentPlayer.X){
                checkResults(results, player1);
            }
            else{
                checkResults(results, player2);
            }
            mainInterface.displayBoard(board);
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

    /**
     * Checks whether the game is over or not and returns the results
     * @return 1 if the game is a win, 0 if it's a draw, -1 if the game isn't over
     */
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
     * @param currentPlayer the player who made the final move
     */
    protected void checkResults(int res, Player currentPlayer){
        PlayService newPS = new PlayService();
        if(res == -1){

        }
        else if(res == 1){
            mainInterface.displayBoard(board);
            mainInterface.printResults(currentPlayer.getPlayerName());
            newPS.playGame();
        }
        else if(res == 0){
            mainInterface.displayBoard(board);
            mainInterface.printDraw();
            newPS.playGame();
        }
    }
}