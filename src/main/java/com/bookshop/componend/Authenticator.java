package main.java.com.bookshop.componend;

import main.java.com.bookshop.Main;

public class Authenticator {

    private static final String PASSWORD = "default";

    public static boolean authentication() {
        boolean accepted = false;
        for (int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String userInput = Main.SC.nextLine();
            if (userInput.equals(PASSWORD)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please, check your password.");
            }
        }
        System.out.println( accepted ?"Welcome to our book shop!": "Application has been blocked.");
        return accepted;
    }
}
