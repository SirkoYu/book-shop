package main.java.com.bookshop;

import java.util.Scanner;

public class Main {

    static String PASSWORD = "default";
    static Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        run();
    }
    static void run(){
        boolean accepted = false;
        for (int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String userInput = SC.nextLine();
            if (userInput.equals(PASSWORD)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please, check your password.");
            }
        }
        System.out.println( accepted ?"Welcome!": "Application has been blocked.");
    }
}