package Arr_Game_CrossAndNull;

import java.io.IOException;
import java.util.Scanner;

public class StartGameCrossAndNull {
    public static void main(String[] args) throws IOException {
        System.out.println("4. Small Game ");
        System.out.print("------------------------------");
        System.out.print("\n");
        String exitGame;
            do {
                do {
                    Scanner input = new Scanner(System.in);
                    System.out.println(" Enter please any kay");
                    String ex = input.next();
                    exitGame = ex;
                    CrossAndNull.showAll();
                    break;
                } while (exitGame.equals("n"));
            } while (exitGame == "n");
            System.out.println(" Triggered this operator WHILE and EXIT GAME");
        }
}