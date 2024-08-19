package main.java.com.bookshop.componend;

import main.java.com.bookshop.Main;
import main.java.com.bookshop.model.Book;
import main.java.com.bookshop.model.Client;
import main.java.com.bookshop.service.BookService;
import main.java.com.bookshop.service.ClientService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityRegister {
    private final ClientService clientService = new ClientService();
    private final BookService bookService = new BookService();
    public void registerClients(){
        List<Client> clients = new ArrayList<>();

        do {
            Client client = addClient();
            if (client != null) clients.add(client);
        } while (verifyRepeating("Do you want to register more clients? (type \"yes\" if you want to): "));

        Map<Client.Location, List<Client>> clientsByLocation = groupClients(clients);
        printClients(clientsByLocation);
    }

    private void printClients(Map<Client.Location, List<Client>> clientsByLocation) {
        for (Map.Entry<Client.Location, List<Client>> clients : clientsByLocation.entrySet()) {
            String content = STR."\n Location \{clients.getKey()}\n Clients (\{clients.getValue().size()}): \n\t\{clients.getValue()}";

            System.out.println(content);
        }
    }
    private Map<Client.Location, List<Client>> groupClients(List<Client> clients) {
        List<Client> fromKyiv = new ArrayList<>();
        List<Client> fromLviv = new ArrayList<>();
        List<Client> fromOdesa = new ArrayList<>();
        List<Client> unknownLocation = new ArrayList<>();

        for(Client client: clients){
            switch (client.getLocation()){
                case KYIV -> fromKyiv.add(client);
                case LVIV -> fromLviv.add(client);
                case ODESA -> fromOdesa.add(client);
                case UNKNOWN -> unknownLocation.add(client);
            }
        }

        Map<Client.Location, List<Client>> clientsByLocation = new HashMap<>();
        clientsByLocation.put(Client.Location.KYIV, fromKyiv);
        clientsByLocation.put(Client.Location.LVIV, fromLviv);
        clientsByLocation.put(Client.Location.ODESA, fromOdesa);
        clientsByLocation.put(Client.Location.UNKNOWN, unknownLocation);

        return clientsByLocation;
    }

    private Client addClient(){
        Client client = clientService.registerNewClient();
        if (client != null){
            System.out.print("Do you want to add new books right now? (type \"yes\" if you want to): ");
            String input = Main.SC.nextLine();
            if(input.equals("yes")) {
                registerBooks(client);
            }
        }
        return client;
    }
    private void registerBooks(Client client){
        boolean continueAddingBooks = true;

        do {
            addBook(client);
        } while (verifyRepeating("Do you want to add more books to this client? (type \"yes\" if you want to): "));
    }
    private void addBook(Client client){
        System.out.println("Adding a new book.");

        Book book = bookService.registerNewBook();
        client.addBook(book);

        System.out.println("Book has been added.");
    }

    private boolean verifyRepeating(String message){
        System.out.print(message);
        String answer = Main.SC.nextLine();
        if(answer.equals("yes"))
            return true;
        else if (answer.equals("no"))
            return false;
        else {
            System.out.println("Incorrect input. Please try again.");
            return verifyRepeating(message);
        }
    }
}
