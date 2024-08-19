package main.java.com.bookshop.service;

import main.java.com.bookshop.Main;
import main.java.com.bookshop.model.Book;

import java.util.Optional;

public class BookService {

    public Optional<Book> registerNewBook(){
        return buildBook();
    }

    private Optional<Book> buildBook() {
        Book book = new Book();
        System.out.print("Name: ");
        book.setName(Main.SC.nextLine());
        System.out.print("Author: ");
        book.setAuthor(Main.SC.nextLine());
        System.out.print("Genre: ");
        book.setGenre(Main.SC.nextLine());
        System.out.print("Price: ");
        book.setPrice(Integer.parseInt(Main.SC.nextLine()));

        return Optional.of(book);
    }
}
