package UniversityLibrary;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        LibraryAdmin libraryAdmin = new LibraryAdmin();
        Scanner scanner = new Scanner(System.in);

        // Adding Sample Books
        Book javaBook = new Book();
        javaBook.setBookTitle("Java Programming Essentials");
        javaBook.setAuthor("James Gosling");
        javaBook.setIsbnNumber("12345");
        libraryAdmin.addNewBook(javaBook);

        Book pythonBook = new Book();
        pythonBook.setBookTitle("Mastering Python");
        pythonBook.setAuthor("Guido van Rossum");
        pythonBook.setIsbnNumber("67890");
        libraryAdmin.addNewBook(pythonBook);

        // Adding Sample Users
        Users alice = new Users();
        alice.setName("Alice");
        alice.setUserId("U1001");
        libraryAdmin.registerUser(alice);

        Users bob = new Users();
        bob.setName("Bob");
        bob.setUserId("U1002");
        libraryAdmin.registerUser(bob);

        System.out.println("\n📚 Welcome to the University Library Portal! 📚");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Borrow a Book");
            System.out.println("2. Return a Book");
            System.out.println("3. Reserve a Book");
            System.out.println("4. Find a Book");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // To consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    String borrowUserID = scanner.nextLine();
                    System.out.print("Enter Book ISBN: ");
                    String borrowISBN = scanner.nextLine();
                    try {
                        libraryAdmin.borrowFromLibrary(borrowISBN, borrowUserID);
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    String returnUserID = scanner.nextLine();
                    System.out.print("Enter Book ISBN: ");
                    String returnISBN = scanner.nextLine();
                    try {
                        libraryAdmin.returnToLibrary(returnISBN, returnUserID);
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    String reserveUserID = scanner.nextLine();
                    System.out.print("Enter Book ISBN: ");
                    String reserveISBN = scanner.nextLine();
                    try {
                        libraryAdmin.reserveInLibrary(reserveISBN, reserveUserID);
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter Book Title: ");
                    String searchTitle = scanner.nextLine();
                    Book foundBook = libraryAdmin.findBookByTitle(searchTitle);
                    if (foundBook != null) {
                        System.out.println("✅ Book Found: " + foundBook.getBookTitle() + " by " + foundBook.getAuthor());
                    } else {
                        System.out.println("❌ Book Not Found!");
                    }
                    break;

                case 5:
                    System.out.println("📚 Thank you for using the University Library Portal! Exiting... 🚪");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice! Please enter a valid option.");
            }
        }
    }
}
