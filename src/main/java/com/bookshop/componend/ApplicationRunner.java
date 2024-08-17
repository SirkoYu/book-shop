package main.java.com.bookshop.componend;

import main.java.com.bookshop.Main;
import main.java.com.bookshop.model.Book;
import main.java.com.bookshop.model.Client;
import main.java.com.bookshop.service.BookService;
import main.java.com.bookshop.service.ClientService;

public class ApplicationRunner {

    private ClientService clientService = new ClientService();
    private BookService bookService = new BookService();

    public void run(){
        if(Authenticator.authentication()){
            Client client = clientService.registerNewClient();
            if (client != null){
                System.out.print("Do you want to add new book right now? (type \"yes\" if you want to): ");
                String input = Main.SC.nextLine();
                if(input.equals("yes")) {
                    System.out.println("Adding a new book.");

                    Book book = bookService.registerNewBook();
                    client.setBook(book);

                    System.out.println("Book has been added.");
                }
            }
        }

    }
}
