package ui.layer;

import business.layer.PlayService;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Hrafnkell on 26/10/2016.
 */
public class Interface {

    /**
     * Need to figure out where what class the main function should be.
     */
    /*public static void main(String args[]){
        playService = new PlayService();
        System.out.println("    Welcome to tic-tac-toe!"); //temp location for this print
        mainMenu();
    }*/

    public static String mainMenu(){

        System.out.println("+------------------------------+");
        System.out.println("|Please select an option below |");
        System.out.println("+------------------------------+");
        System.out.println("|1 -- play against the computer|");
        System.out.println("|2 -- play against an opponent |");
        System.out.println("|Q -- quit the game            |");
        System.out.println("+------------------------------+");
        System.out.print("Enter your choice: ");

        String input = getUserInput();

        return input;

    }

    public int getPlayerChoice(){
        System.out.println("Please choose a number between 1 and 9:");
        Scanner reader = new Scanner(System.in);
        int input = reader.nextInt();
        return input;
    }

    public static void displayBoard(String[] board){

        for (int i = 0; i < board.length; i++){
            System.out.print(board[i] + " ");
            if ((i + 1) % 3 == 0){
                System.out.print("\n");
            }
        }
    }

    private static String getUserInput(){
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        reader.close();

        return input;
    }

    public static String printWelcomeMessage(){
        return "    Welcome to tic-tac-toe!"; //temp location for this print
    }
}