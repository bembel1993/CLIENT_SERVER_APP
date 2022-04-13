package Messenger.Woman;

import Arr_Game_CrossAndNull.CrossAndNull;
import Messenger.Person.Person;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

public class Woman<S, T> extends Person<S, T> {
    public Socket socket;
    public BufferedReader br;
    public BufferedWriter bw;
    public BufferedReader cois;
    public BufferedWriter coos;
    public BufferedReader inputUser;
    public static File text = new File("Save_Massage.txt");
    public String str;
    public String str2;
    private char untensils;
    private int Id;
    private static int user; //статическая переменная, стат. переменная может вызываться без создания объекта класса

    static {
        user = 201;
        System.out.printf("Welcomm user! Your ID: %d\n", user);
    }

    public Woman(S firstName, S lastName, T day_born,
                 T month_born, T year_born, String country,
                 char who) {
        super(firstName, lastName, day_born, month_born, year_born, country);
        this.Id = user;
        this.untensils = who;
        Id = user++;
    }

    @Override
    public void display() {
        System.out.print("Name: " + super.getFirstName() + " " + super.getLastName() + "\n " + "Born: " +
                super.getDay_born() + "." + super.getMonth_born() + "." +
                super.getYear_born() + " in " + super.getCountry() + "\n Gender: " + untensils);
    }

    public static void displayUser() {
        System.out.printf("\nUser: %d\n", user);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void demoCaseMenuInfo(int push) throws IOException, ClassNotFoundException {
        switch (push) {
            case '1':
                System.out.println("1. My side ");
                System.out.println("-----------------------------");
                System.out.print("Name: " + super.getFirstName() + " " + super.getLastName() + "\n " + "Born: " +
                        super.getDay_born() + "." + super.getMonth_born() + "." +
                        super.getYear_born() + " from " + super.getCountry() + "\n Gender: " + untensils + "\n");
                System.out.println("-----------------------------");
                break;
            case '2':
                //соединения клиента с сервером
                try {
                    socket = new Socket("127.0.0.1", 2020);
                    System.out.println("connection established....");
                    //   new BufferedReader(new InputStreamReader(client.getInputStream()));
                    //   new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                    coos = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    cois = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    inputUser = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("2. Message ");
                    System.out.println("------------------------------");
                    //      System.out.print("\nWrite here pleas message ");
                    br = new BufferedReader(new InputStreamReader(System.in));
                    bw = new BufferedWriter(new FileWriter("SaveMesseg.txt"));

                    FileWriter fileWriter = new FileWriter(text, true);
                    bw = new BufferedWriter(fileWriter);

                    System.out.println(" enter -x- for exit or -c- to continue");

                    str2 = br.readLine();
                    if (str2.equals("x")) break;
                    else if (str2.equals("c")) {
                        System.out.println("You want write message ? ");
                        do {
                            str2 = br.readLine();
                            if (str2.equals("yes")) {
                                System.out.println("Good! Write and push enter.");
                                //new WriteMsg().start();
                                run();
                                new Woman.ReadMsg().start();
                                bw.write("Message from " + getFirstName() + " " + getLastName() + ": "
                                        + "\n" + "Content: " + str + " " + "\nSend: " + date());
                            }
                        } while (!str2.equals("no"));
                        break;
                    }
                } catch (IOException e) {
                    Woman.this.downService();
                    break;
                }
            case '3':
                System.out.println("3. Send Message ");
                System.out.print("------------------------------");
                System.out.print("\n");
                try (FileReader reader = new FileReader(new File("SaveMesseges.txt"))) {
                    char[] buf = new char[500];
                    int c;
                    while ((c = reader.read(buf)) > 0) {
                        if (c < 500) {
                            buf = Arrays.copyOf(buf, c);
                        }
                        System.out.print(buf);
                        System.out.print("\n");
                    }
                } catch (IOException e) {
                    System.out.println("Файл не найден.");
                }
                break;
            case '4':
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
        System.out.println();
    }

    @Override
    public void showMenu() {
        System.out.println(" Menu ");
        System.out.println(" 1. My side");
        System.out.println(" 2. Message");
        System.out.println(" 3. Send Message");
        System.out.println(" 4. Small game");
        System.out.println("Push q for exit: ");
    }

    @Override
    public boolean isValid(int ch) {
        if (ch < '1' | ch > '4' & ch != 'q') {
            return true;
        } else {
            return false;
        }
    }

    public void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (IOException ignored) {
        }
    }

    // нить чтения сообщений с сервера
    private class ReadMsg extends Thread {
        @Override
        public void run() {

            String str;
            try {
                while (true) {
                    str = cois.readLine(); // ждем сообщения с сервера
                    System.out.println("~Server~ " + str); // пишем сообщение с сервера на консоль
                    bw.write(str);
                    System.out.println("Enter -yes- when you continue or -no- for exit: ");
                }
            } catch (IOException e) {
                Woman.this.downService();
            }
        }
    }

    // нить отправляющая сообщения приходящие с консоли на сервер
    //  public class WriteMsg extends Thread {

    @Override
    public void run() {
        String userWord;
        while (true) {
            try {
                userWord = inputUser.readLine();// сообщения с консоли
                coos.write(getFirstName() + " " + getLastName() + ": "
                        + userWord + "\n"); // отправляем на сервер
                bw.write("\nMessage from " + getFirstName() + " " + getLastName() + ": "
                        + "\n" + "Content: " + userWord + " " + "\nSend: " + date());
                //  }
                // downService();
                //  bw.close();
                //  Thread.sleep(2000);
                coos.flush();
                // чистим
                if (userWord.equals("ex")){
                    downService();
                    bw.close();
                }
            } catch (IOException e) {
                Woman.this.downService(); // в случае исключения закрыть
            }
            break;
        }
    }
}
