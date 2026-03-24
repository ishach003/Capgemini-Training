package di;

public class Book {

    private int bookId;
    private String bookName;

    // Getter for bookId
    public int getBookId() {
        return bookId;
    }

    // Setter for bookId
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    // Getter for bookName
    public String getBookName() {
        return bookName;
    }

    // Setter for bookName
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    // toString method
    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}