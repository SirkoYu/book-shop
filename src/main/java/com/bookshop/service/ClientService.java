package main.java.com.bookshop.service;

import main.java.com.bookshop.Main;
import main.java.com.bookshop.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static String EMAIL_PATTERN = "^[a-zA-z0-9._%+-]+@[a-zA-z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static String NAME_PATTERN = "^[a-zA-Z-]{3,}$";

    public Client registerNewClient() {
        Client client = null;
        System.out.println("Please, provide a client details.");
        System.out.print("Email: ");
        String email = Main.SC.nextLine();

        if(isInputValid(email, EMAIL_PATTERN)){
            client = buildClient(email);

            if (client != null) {
                System.out.println(STR."New client: \{client.getFirstname()} \{client.getLastname()} (\{client.getEmail()})");
            }

        } else {
            System.out.println("This email is not valid.");
        }
        return client;
    }
    private static Client buildClient(String email) {
        Client client = new Client();
        client.setEmail(email);

        System.out.print("Firstname: ");
        String firstname = Main.SC.nextLine();
        if (isInputValid(firstname, NAME_PATTERN)){
            client.setFirstname(firstname);
        } else{
            System.out.println("Firstname is not valid.");
            return null;
        }

        System.out.print("Lastname: ");
        String lastname = Main.SC.nextLine();
        if (isInputValid(lastname, NAME_PATTERN)){
            client.setLastname(lastname);
        } else {
            System.out.println("Lastname is not valid.");
            return null;
        }

        System.out.print("Location: ");
        String location = Main.SC.nextLine();
        client.setLocation(Client.Location.valueOf(location));

        return client;
    }

    private static boolean isInputValid(String input, String expression) {
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(input);
        return  matcher.matches();
    }
}
