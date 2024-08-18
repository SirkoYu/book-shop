package main.java.com.bookshop.comparator;

import main.java.com.bookshop.model.Book;

import java.util.Comparator;

public class BookNameComparator implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        int result = book1.getName().compareTo(book2.getName());
        if(result==0)
            return book1.getPrice() - book2.getPrice();
        else return result;
    }
}
