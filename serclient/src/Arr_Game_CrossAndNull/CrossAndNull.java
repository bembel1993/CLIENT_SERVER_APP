package Arr_Game_CrossAndNull;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class CrossAndNull {
    public static String[][] field = new String[4][4];
    public static int x = 1;
    public static int z = 0;
    public static int move = 0;
    public static int moveX = 0;
    public static int move0 = 0;
    public static boolean valid;
    public static String gambler;
    public static String gamblerNull = "0";
    public static String gamblerX = "x";
    public static String endGame = "q";
    public static String pictures;
    public static String wish;
    public static String wish1 = "y";
    public static String wish2 = "n";
    public static int scoreX = 0;
    public static int scoreNull = 0;
    public static File scoreGame = new File("Score GAME.txt");

    public static void presentGame() {
        pictures =
                "  +#####@                                                  ###  ####+  #### ###       ####+  ####            ##### ##### \n" +
                        " #########:                 .                              ###  #####  #### ###       #####  ####            ##### #####  \n" +
                        " ####  #### #### ####% ########* .########-.########-       #   ###### ####  #        ###### ####  ####  ### ##### #####  \n" +
                        " ####  %%%% ##############  #### ####   #####   #####           ######:####           ######:####  ####  ### ##### #####  \n" +
                        " ####       ######  ######  #### -#####-   -#####-              ###########           ###########  ####  ### ##### #####  \n" +
                        " ####  #### #####     ####  ####    ######.   ######.           ####.######           ####.######  ####  ### ##### #####  \n" +
                        " ####  #### #####     ####  #### ####   #######   ####          #### ######           #### ######  ####  ### ##### #####  \n" +
                        " #########. #####     -######### *########**########*           ####  #####           ####  #####  #########.##### #####  \n" +
                        "   *###=.   #####       .%##@:     :@##@-    :@##@-             ####  @####           ####  @####   @#= #### ##### #####\n";

        System.out.println(pictures);
    }

    ////////METHOD_ONE_///////////////////////////////
    public static void initializationField() {
        System.out.println("\t\t***Welcome in Game***");
        System.out.println("\n_-_-_-_-_-_-CROSS AND NULL-_-_-_-_-_-_\n");
        field[1][1] = "1";
        field[1][2] = "4";
        field[1][3] = "7";
        field[2][1] = "2";
        field[2][2] = "5";
        field[2][3] = "8";
        field[3][1] = "3";
        field[3][2] = "6";
        field[3][3] = "9";
        for (x = 1; x < field.length; x++) {
            System.out.println("|---+---+---|");
            for (z = 1; z < field[x].length; z++) {
                System.out.print("| " + field[z][x] + "\t");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("|---+---+---|");
    }

    ////////METHOD_TWO_///////////////////////////////
    public static <e, ex, file> void logicGameCrossAndNull() throws IOException {
        //   for (; ; ) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fileWriter = new FileWriter(scoreGame, true);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        do {
            move++;
            for (x = 1; x < 2; x++) {
                System.out.print("Enter Player X or 0 (|q| to interrupt the game): ");
                Scanner enter_player = new Scanner(System.in);
                gambler = enter_player.next();

                if (gambler.equals(gamblerX)) {
                    moveX++;
                    valid = true;
                    System.out.println("Player - X");
                    System.out.println("Player-X move: " + moveX + " " + valid);
                    System.out.println("All move: " + move);
                    System.out.print("Player X enter pleas number field: ");
                    Scanner enter_number_field = new Scanner(System.in);
                    int number_field_one = enter_number_field.nextInt();
                    System.out.println("|---+---+---|");
                    if (number_field_one == 1 && field[1][1] != gamblerNull) {
                        field[1][1] = gamblerX;
                        valid = true;
                    } else if (number_field_one == 2 && field[2][1] != gamblerNull) {
                        field[2][1] = gamblerX;
                    } else if (number_field_one == 3 && field[3][1] != gamblerNull) {
                        field[3][1] = gamblerX;
                    } else if (number_field_one == 4 && field[1][2] != gamblerNull) {
                        field[1][2] = gamblerX;
                    } else if (number_field_one == 5 && field[2][2] != gamblerNull) {
                        field[2][2] = gamblerX;
                    } else if (number_field_one == 6 && field[3][2] != gamblerNull) {
                        field[3][2] = gamblerX;
                    } else if (number_field_one == 7 && field[1][3] != gamblerNull) {
                        field[1][3] = gamblerX;
                    } else if (number_field_one == 8 && field[2][3] != gamblerNull) {
                        field[2][3] = gamblerX;
                    } else if (number_field_one == 9 && field[3][3] != gamblerNull) {
                        field[3][3] = gamblerX;
                    }
                } else if (gambler.equals(gamblerNull)) {
                    move0++;
                    valid = true;
                    System.out.println("Player - 0");
                    System.out.println("Player-0 move: " + move0 + " " + valid);
                    System.out.println("All move: " + move0);
                    System.out.print("Player 0 enter pleas number field: ");
                    Scanner enter_number_field = new Scanner(System.in);
                    int number_field_one = enter_number_field.nextInt();
                    System.out.println("|---+---+---|");
                    if (number_field_one == 1 && field[1][1] != gamblerX) {
                        field[1][1] = gamblerNull;
                        valid = true;
                    } else if (number_field_one == 2 && field[2][1] != gamblerX) {
                        field[2][1] = gamblerNull;
                    } else if (number_field_one == 3 && field[3][1] != gamblerX) {
                        field[3][1] = gamblerNull;
                    } else if (number_field_one == 4 && field[1][2] != gamblerX) {
                        field[1][2] = gamblerNull;
                    } else if (number_field_one == 5 && field[2][2] != gamblerX) {
                        field[2][2] = gamblerNull;
                    } else if (number_field_one == 6 && field[3][2] != gamblerX) {
                        field[3][2] = gamblerNull;
                    } else if (number_field_one == 7 && field[1][3] != gamblerX) {
                        field[1][3] = gamblerNull;
                    } else if (number_field_one == 8 && field[2][3] != gamblerX) {
                        field[2][3] = gamblerNull;
                    } else if (number_field_one == 9 && field[3][3] != gamblerX) {
                        field[3][3] = gamblerNull;
                    }
                } else {
                    System.out.println("Such Player is not, try again");
                }
                valid = true;
                for (z = 1; z < field[x].length; z++) {
                }
            }
            for (x = 1; x < field.length; x++) {
                for (z = 1; z < field[x].length; z++) {
                    System.out.print("| " + field[z][x] + "\t");
                }
                System.out.print("|");
                System.out.println();
                System.out.println("|---+---+---|");
            }
            if (gambler.equals(endGame)) {
                System.out.println("Player exit out game");
                break;
            }
        } while (valid != false ||/*move <= field.length &&*/ !gambler.equals(endGame) /*|| !gamblerX.equals(wish2)*/);
        if (//moveX <= field.length && gamblerX == "x" ||
            // move <= field.length &&
                field[1][1] == gamblerX && field[2][1] == gamblerX && field[3][1] == gamblerX ||
                        field[1][2] == gamblerX && field[2][2] == gamblerX && field[3][2] == gamblerX ||
                        field[1][3] == gamblerX && field[2][3] == gamblerX && field[3][3] == gamblerX ||
                        field[1][1] == gamblerX && field[1][2] == gamblerX && field[1][3] == gamblerX ||
                        field[2][1] == gamblerX && field[2][2] == gamblerX && field[2][3] == gamblerX ||
                        field[3][1] == gamblerX && field[3][2] == gamblerX && field[3][3] == gamblerX ||
                        field[1][1] == gamblerX && field[2][2] == gamblerX && field[3][3] == gamblerX ||
                        field[1][3] == gamblerX && field[2][2] == gamblerX && field[3][1] == gamblerX) {
            //str = br.readLine();
            scoreX = scoreX + 100;
            scoreNull = scoreNull - 100;
            // text = str;
            //     bw.write("X| Player-X have " + "||" + scoreX + "||" + " score.\n"+
            //           "| Player-0 have " + "||" + scoreNull + "||" + " score.\n\n");
            // bw.flush();
            System.out.println("+---------------------------------------------------+");
            System.out.println("| Player-X CONGRATULATION!!! You WINNER Player-X!!! ");
            System.out.println("| Player-X have " + "||" + scoreX + "||" + " score.");
            System.out.println("| Player-0 have " + "||" + scoreNull + "||" + " score.");
            System.out.println("+---------------------------------------------------+");
        } else if (//move0 <= field.length && gamblerNull == "0" ||
                field[1][1] == gamblerNull && field[2][1] == gamblerNull && field[3][1] == gamblerNull ||
                        field[1][2] == gamblerNull && field[2][2] == gamblerNull && field[3][2] == gamblerNull ||
                        field[1][3] == gamblerNull && field[2][3] == gamblerNull && field[3][3] == gamblerNull ||
                        field[1][1] == gamblerNull && field[1][2] == gamblerNull && field[1][3] == gamblerNull ||
                        field[2][1] == gamblerNull && field[2][2] == gamblerNull && field[2][3] == gamblerNull ||
                        field[3][1] == gamblerNull && field[3][2] == gamblerNull && field[3][3] == gamblerNull ||
                        field[1][1] == gamblerNull && field[2][2] == gamblerNull && field[3][3] == gamblerNull ||
                        field[1][3] == gamblerNull && field[2][2] == gamblerNull && field[3][1] == gamblerNull) {
            scoreNull = scoreNull + 100;
            scoreX = scoreX - 100;
            //    bw.write("0| Player-0 have " + "||" + scoreNull + "||" + " score.\n"+
            //  "| Player-X have " + "||" + scoreX + "||" + " score.\n\n");
            //bw.flush();
            System.out.println("+---------------------------------------------------+");
            System.out.println("| Player-0 CONGRATULATION!!! You WINNER Player-0!!! ");
            System.out.println("| Player-0 have " + "||" + scoreNull + "||" + " score.");
            System.out.println("| Player-X have " + "||" + scoreX + "||" + " score.");
            System.out.println("+---------------------------------------------------+");
        } else {
            scoreNull = scoreNull;
            scoreX = scoreX;
            System.out.println("Not WINNER! This is a draw!");
            // bw.write("DRAW| Player-0 have " + "||" + scoreNull + "||" + " score.\n"+
            //       "| Player-X have " + "||" + scoreX + "||" + " score.\n\n");
        }
        //////////////////////////////////////////////////////////////////////// SAVE IN FILE
        bw.write("| Player-X have " + "||" + scoreX + "||" + " score.\n" +
                "| Player-0 have " + "||" + scoreNull + "||" + " score.\n\n");
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////// OUTPUT FILE TO READ
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("<<<<<<<SCORE GAME --- OUTPUT TEXT FILE>>>>>>>>> ");
        System.out.print("------------------------------");
        System.out.print("\n");
        FileReader reader = new FileReader(scoreGame);
        char[] buf = new char[500];
        int c;
        while ((c = reader.read(buf)) > 0) {
            if (c < 500) {
                buf = Arrays.copyOf(buf, c);
            }
            System.out.print(buf);
            System.out.print("\n");
        }
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||");
        ////////////////////////////////////////////////////////////////// FILE TO READ
   /*         if (gambler.equals(endGame)) {
                System.out.println("-=::::::=-Game is over-=::::::=-");
                break;
            }*/
        //  }
    }

    ////////METHOD_THREE_///////////////////////////////
    public static void showBoardAndResultGame() {
        System.out.println();
        for (x = 1; x < field.length; x++) {
            System.out.println("|---+---+---|");
            for (z = 1; z < field[x].length; z++) {
                System.out.print("| " + field[z][x] + "\t");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("|---+---+---|");
        System.out.println();
        System.out.println("RESULT GAME: ");
        System.out.println(field[1][1] + " " + field[2][1] + " " + field[3][1]);
        System.out.println(field[1][2] + " " + field[2][2] + " " + field[3][2]);
        System.out.println(field[1][3] + " " + field[2][3] + " " + field[3][3]);

    }

    ////////METHOD_FOUR_///////////////////////////////
    public static void showAll() throws IOException {
        for (; ; ) {
            do {
                System.out.println(" *** Do you wont play in the game? ***");
                System.out.println(" *** Push -y- or -n- ***");
                Scanner enter_wish = new Scanner(System.in);
                wish = enter_wish.next();
                CrossAndNull.presentGame();
                do {
                    if (wish.equals(wish1)) {
                        CrossAndNull.initializationField();
                        do {
                            CrossAndNull.logicGameCrossAndNull();
                            CrossAndNull.showBoardAndResultGame();
                            break;
                        } while (!gambler.equals(endGame));
                        if (wish.equals(endGame)) break;
                    } else {
                        System.out.println("Break");
                        break;
                    }
                } while (wish.equals(endGame));
            } while (!wish.equals(wish2));
            System.out.println("--- Exit out game.---");
            break;
        }
    }
}
