package ui.layer;

import business.layer.PlayService;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Hrafnkell on 26/10/2016.
 */
public class Interface {

    private static PlayService playService;

    public static void main(String args[]){
        playService = new PlayService();
        menu();
    }

    public static void menu(){
        boolean cont = true;
        System.out.println("    Welcome to tic-tac-toe!");

        while (cont) {
            System.out.println("+------------------------------+");
            System.out.println("|Please select an option below |");
            System.out.println("+------------------------------+");
            System.out.println("|1 -- play against the computer|");
            System.out.println("|2 -- play against an opponent |");
            System.out.println("|Q -- quit the game            |");
            System.out.println("+------------------------------+");
            System.out.print("Enter your choice: ");
            String input = getUserInput();

            if (input.equals("1")){
                displayBoard();
            }
            else if (input.equals("2")){
                displayBoard();
            }
            else if(input.equals("q") || input.equals("Q")){
                displayBoard();
            }
            else {
                System.out.println("Enter a valid input, please.");
            }

            System.out.println("Do you want to play another game? (y/n)");
            String in = System.in.toString();
            if (!(in.equals("y|Y"))){
                cont = false;
            }
        }


    }

    public static void displayBoard(){

        for (int i = 0; i < playService.getSize(); i++){
            System.out.print(playService.getNext(i) + " ");
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
}