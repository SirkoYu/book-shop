package main.java.com.bookshop;

import main.java.com.bookshop.model.Book;

import java.util.Arrays;
import java.util.Comparator;

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
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                int result = o1.getName().compareTo(o2.getName());

                if(result == 0 ) return o1.getPrice() - o2.getPrice();
                else return result;
            }
        });
        System.out.println(Arrays.toString(books));
    }
}
