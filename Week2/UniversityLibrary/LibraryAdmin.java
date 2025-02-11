package UniversityLibrary;

import java.util.ArrayList;
import java.util.List;

public class LibraryAdmin extends LibrarySystem {
    private static final int MAX_BOOK_LIMIT = 3; // Max books a user can borrow

    // Constructor to initialize book and user lists
    public LibraryAdmin() {
        this.availableBooks = new ArrayList<>();
        this.registeredUsers = new ArrayList<>();
    }

    // Add a new book to the library system
    @Override
    public void addNewBook(Book book) {
        availableBooks.add(book);
        System.out.println("New book added: " + book.getBookTitle());
    }

    // Add a new user to the library system
    @Override
    public void registerUser(Users user) {
        registeredUsers.add(user);
        System.out.println("New user registered: " + user.getName());
    }

    // Borrow a book from the library
    @Override
    public synchronized void borrowFromLibrary(String ISBN, String userID) throws BookMissingException, UserMissingException, BorrowLimitExceededException {
        Users user = findUserInSystem(userID);
        Book book = findBookInLibrary(ISBN);

        if (user.getBorrowedBooks().size() >= MAX_BOOK_LIMIT) {
            throw new BorrowLimitExceededException("User has reached the maximum borrowing limit.");
        }

        user.getBorrowedBooks().add(book);
        availableBooks.remove(book);
        System.out.println(user.getName() + " borrowed " + book.getBookTitle());
    }

    // Return a borrowed book to the library
    @Override
    public synchronized void returnToLibrary(String ISBN, String userID) throws BookMissingException, UserMissingException {
        Users user = findUserInSystem(userID);
        Book book = findBookInLibrary(ISBN);

        if (!user.getBorrowedBooks().contains(book)) {
            throw new BookMissingException("This book was not borrowed by the user.");
        }

        user.getBorrowedBooks().remove(book);
        availableBooks.add(book);
        System.out.println(user.getName() + " returned " + book.getBookTitle());
    }

    // Reserve a book in the library
    @Override
    public void reserveInLibrary(String ISBN, String userID) throws BookMissingException, UserMissingException {
        Users user = findUserInSystem(userID);
        Book book = findBookInLibrary(ISBN);

        System.out.println(user.getName() + " reserved " + book.getBookTitle());
    }

    // Search for a book by title
    @Override
    public Book findBookByTitle(String title) {
        for (Book book : availableBooks) {
            if (book.getBookTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Helper method to find a user in the system
    private Users findUserInSystem(String userID) throws UserMissingException {
        for (Users user : registeredUsers) {
            if (user.getUserId().equals(userID)) {
                return user;
            }
        }
        throw new UserMissingException("User not found: " + userID);
    }

    // Helper method to find a book in the library
    private Book findBookInLibrary(String ISBN) throws BookMissingException {
        for (Book book : availableBooks) {
            if (String.valueOf(book.getIsbnNumber()).equals(ISBN)) {
                return book;
            }
        }
        throw new BookMissingException("Book not found: ISBN " + ISBN);
    }
}
