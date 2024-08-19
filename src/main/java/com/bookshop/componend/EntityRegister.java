package main.java.com.bookshop.componend;

import main.java.com.bookshop.Main;
import main.java.com.bookshop.model.Book;
import main.java.com.bookshop.model.Client;
import main.java.com.bookshop.service.BookService;
import main.java.com.bookshop.service.ClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EntityRegister {
    private final ClientService clientService = new ClientService();
    private final BookService bookService = new BookService();
    public void registerClients(){
        List<Client> clients = new ArrayList<>();

        do {
            Optional<Client> client = addClient();
            client.ifPresent(clients::add);
        } while (verifyRepeating("Do you want to register more clients? (type \"yes\" if you want to): "));

        Map<Client.Location, List<Client>> clientsByLocation = clients.stream()
                .collect(Collectors.groupingBy(Client::getLocation));
        printClients(clientsByLocation);
    }

    private void printClients(Map<Client.Location, List<Client>> clientsByLocation) {
        for (Map.Entry<Client.Location, List<Client>> clients : clientsByLocation.entrySet()) {
            String content = STR."\n Location \{clients.getKey()}\n Clients (\{clients.getValue().size()}): \n\t\{clients.getValue()}";

            System.out.println(content);
        }
    }

    private Optional<Client> addClient(){
        Optional<Client> client = clientService.registerNewClient();
        client.ifPresent(this::registerBooks);

        return client;
    }
    private void registerBooks(Client client){

        do {
            addBook(client);
            System.out.println(client);
        } while (verifyRepeating("Do you want to add more books to this client? (type \"yes\" if you want to): "));
    }
    private void addBook(Client client){
        System.out.println("Adding a new book.");

        Optional<Book> book = bookService.registerNewBook();
        book.ifPresent(client::addBook);

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
