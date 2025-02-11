package UniversityLibrary;
import java.util.*;

public class LibraryUser {
    private String fullName;
    private String userIdentifier;
    private List<Book> booksBorrowed;

    public LibraryUser() {
        this.booksBorrowed = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public List<Book> getBooksBorrowed() {
        return booksBorrowed;
    }

    public void borrowBook(Book book) {
        booksBorrowed.add(book);
    }

    public void returnBook(Book book) {
        booksBorrowed.remove(book);
    }

    public void setBooksBorrowed(List<Book> booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }

    @Override
    public String toString() {
        return "User: " + fullName + " | ID: " + userIdentifier + " | Books Borrowed: " + booksBorrowed;
    }
}
