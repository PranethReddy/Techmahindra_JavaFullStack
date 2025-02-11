package UniversityLibrary;
import java.util.ArrayList;
import java.util.List;

public abstract class LibraryBase implements LibraryInterface {
    protected List<Book> libraryBooks;
    protected List<LibraryUser> libraryUsers;

    public LibraryBase() {
        this.libraryBooks = new ArrayList<>();
        this.libraryUsers = new ArrayList<>();
    }

    // Abstract methods for adding books and users
    public abstract void addLibraryBook(Book book);
    public abstract void addLibraryUser(LibraryUser user);

    @Override
    public Book findBookByTitle(String title) {
        for (Book book : libraryBooks) {
            if (book.getBookTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;  // Return null if no match found
    }
}
