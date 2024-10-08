package main.java.com.bookshop.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Book {

    private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
    private String name;
    private String author;
    private String genre;
    private int price;

    private final LocalDateTime registrationDate = LocalDateTime.now();

    public Book(){}

    public Book(String name, String author, String genre, int price) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return price == book.price && Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, genre, price);
    }

    @Override
    public String toString() {
        return STR."Book{name='\{name}\{'\''}, author='\{author}\{'\''}, genre='\{genre}\{'\''}, price=\{price}, registrationDate=\{registrationDate.format(FORMATTER)}'}";
    }
}
