package main.java.com.bookshop.model;

import java.util.Objects;

public class Client {
    private String firstname;
    private String lastname;
    private String email;

    private Book book;

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

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return STR."Client{firstname='\{firstname}\{'\''}, lastname='\{lastname}\{'\''}, email='\{email}\{'\''}, book=\n\{book}\{'}'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstname, client.firstname)
                && Objects.equals(lastname, client.lastname)
                && Objects.equals(email, client.email)
                && Objects.equals(book, client.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, email, book);
    }
}
