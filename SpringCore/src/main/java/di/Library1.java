package di;

import java.util.List;

public class Library1 {

    private int id;
    private String name;
    private List<Book> books;

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for books
    public List<Book> getBooks() {
        return books;
    }

    // Setter for books
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    // toString method
    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}