package main.java.com.bookshop;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static String PASSWORD = "default";
    static Scanner SC = new Scanner(System.in);
    static String EMAIL_PATTERN = "^[a-zA-z0-9._%+-]+@[a-zA-z0-9.-]+\\.[a-zA-Z]{2,}$";
    static String NAME_PATTERN = "^[a-zA-Z-]{3,}$";
    public static void main(String[] args) {
        run();
    }
    static void run(){
        if(authentication()){
            registerNewClient();
        }
    }


    private static boolean authentication() {
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
        System.out.println( accepted ?"Welcome to our book shop!": "Application has been blocked.");
        return accepted;
    }


    private static void registerNewClient() {
        System.out.println("Please, provide a client details.");
        System.out.print("Email: ");
        String email = SC.nextLine();

        if(isInputValid(email, EMAIL_PATTERN)){
            Client client = buildClient(email);

            if (client != null)
                System.out.println(STR."New client: \{client.firstname} \{client.lastname} (\{client.email})");

        } else {
            System.out.println("This email is not valid.");
        }
    }

    static Client buildClient(String email) {
        Client client = new Client();
        client.email = email;

        System.out.print("Firstname: ");
        String firstname = SC.nextLine();
        if (isInputValid(firstname, NAME_PATTERN)){
            client.firstname = firstname;
        } else{
            System.out.println("Firstname is not valid.");
            return null;
        }

        System.out.print("Lastname: ");
        String lastname = SC.nextLine();
        if (isInputValid(lastname, NAME_PATTERN)){
            client.lastname = lastname;
        } else {
            System.out.println("Lastname is not valid.");
            return null;
        }

        return client;
    }

    static boolean isInputValid(String input, String expression) {
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(input);
        return  matcher.matches();
    }
}