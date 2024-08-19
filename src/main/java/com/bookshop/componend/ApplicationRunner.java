package main.java.com.bookshop.componend;

import main.java.com.bookshop.Main;
import main.java.com.bookshop.model.Book;
import main.java.com.bookshop.model.Client;
import main.java.com.bookshop.service.BookService;
import main.java.com.bookshop.service.ClientService;

public class ApplicationRunner {

    private final ClientService clientService = new ClientService();
    private final BookService bookService = new BookService();

    public void run(){
        if(Authenticator.authentication()){
            Client client = clientService.registerNewClient();
            if (client != null){
                System.out.print("Do you want to add new books right now? (type \"yes\" if you want to): ");
                String input = Main.SC.nextLine();
                if(input.equals("yes")) {
                    registerBooks(client);
                    System.out.println(client);
                }
            }
        }

    }


    private void registerBooks(Client client){
        boolean continueAddingBooks = true;

        while (continueAddingBooks) {
            addBook(client);
            System.out.print("Do you want to add more books to this client? (type \"yes\" if you want to): ");
            Main.SC.nextLine();
            String input = Main.SC.nextLine();
            if (!input.equals("yes")) {
                continueAddingBooks = false;
            }
        }
    }
    private void addBook(Client client){
        System.out.println("Adding a new book.");

        Book book = bookService.registerNewBook();
        client.addBook(book);

        System.out.println("Book has been added.");
    }
}
