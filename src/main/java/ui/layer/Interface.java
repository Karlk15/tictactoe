package ui.layer;

import business.layer.PlayService;

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
        System.out.println("Welcome to tic-tac-toe!");

        while (cont == true) {
            System.out.println("Enter '1P' to play against the computer, and '2P' to play against an opponent");

            String input = System.in.toString();
            displayBoard();

            if (input == "1P"){

            }
            else if (input == "2P"){

            }
            else{
                System.out.println("Enter a valid input, please.");
            }
            System.out.println("Do you want to play another game? (y/n)");
            String in = System.in.toString();
            if (in != "y|Y"){
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
}
