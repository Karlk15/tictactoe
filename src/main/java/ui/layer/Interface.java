package ui.layer;

import java.util.Scanner;

/**
 * Created by Hrafnkell on 26/10/2016.
 */
public class Interface {


    public String printWelcomeMessage(){
        return "    Welcome to tic-tac-toe!";
    }

    public void printMainMenu(){
        System.out.println("+------------------------------+");
        System.out.println("|Please select an option below |");
        System.out.println("+------------------------------+");
        System.out.println("|1 -- play against the computer|");
        System.out.println("|2 -- play against an opponent |");
        System.out.println("|Q -- quit the game            |");
        System.out.println("+------------------------------+");
        System.out.print("Enter your choice: ");
    }
    private String getPlayerName(){
        Scanner reader = new Scanner(System.in);
        String playerName = reader.nextLine();
        reader.close();

        return playerName;
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

    public static String getMenuInput(){
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        reader.close();

        return input;
    }

    public static void printWrongInput() {
        System.out.println("Invalid input!");
        System.out.println("Try again");
    }

    public String printContinuePlaying() {
        System.out.println("Play again? (y/n)");
        return getMenuInput();
    }

    public void printResults(String winner) {
        System.out.println("GAME OVER");
        System.out.println("Winner is " + winner + "!");
    }

    public void printDraw(){
        System.out.println("Sorry it's a draw!");
    }
}