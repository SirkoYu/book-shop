package main.java.com.bookshop;

import main.java.com.bookshop.comparator.BookNameComparator;
import main.java.com.bookshop.model.Book;

import java.util.Arrays;

public class Sandbox {
    public static void main(String[] args) {
        Book[] books = {
                new Book("Shadows Over the Carpathians",  "Alexander Kovalenko", "Mystery, Adventure", 250),
                new Book("Shadows Over the Carpathians",   "Natalia Vasylenko", " Science Fiction, Thriller", 100),
                new Book("The Magic Portal",  "Irina Bilan", "Fantasy, Romance", 250),
                new Book("The Old Castle's Enigma",  "Andrew Sydorenko", "Detective, Historical", 250),
                new Book("Sun Over the Dnipro",  " Olena Petriv", "Drama, Social Novel", 250)
        };
        System.out.println(Arrays.toString(books));
        Arrays.sort(books, new BookNameComparator());
        System.out.println(Arrays.toString(books));
    }
}
