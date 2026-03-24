package di;

public class Library {

    private int id;
    private String name;
    private Book book;

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

    // Getter for book
    public Book getBook() {
        return book;
    }

    // Setter for book
    public void setBook(Book book) {
        this.book = book;
    }

    // toString method
    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", book=" + book +
                '}';
    }
}