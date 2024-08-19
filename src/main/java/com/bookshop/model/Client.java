package main.java.com.bookshop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
    private String firstname;
    private String lastname;
    private String email;

    private Location location;

    private List<Book> books = new ArrayList<>();

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBook(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return STR."Client{firstname='\{firstname}\{'\''}, lastname='\{lastname}\{'\''}, email='\{email}\{'\''}, location='\{location}\{'\''}, book=\{books}\{'}'}";
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstname, client.firstname)
                && Objects.equals(lastname, client.lastname)
                && Objects.equals(email, client.email)
                && Objects.equals(books, client.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, email, books);
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public enum Location{
        KYIV, LVIV, ODESA, UNKNOWN
    }
}
