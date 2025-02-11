package UniversityLibrary;

// Exception triggered when a book cannot be located
class BookMissingException extends Exception {
    public BookMissingException(String message) {
        super(message);
    }
}

// Exception triggered when a user is not located in the system
class UserMissingException extends Exception {
    public UserMissingException(String message) {
        super(message);
    }
}

// Exception triggered when a user exceeds the book borrowing limit
class BorrowLimitExceededException extends Exception {
    public BorrowLimitExceededException(String message) {
        super(message);
    }
}
