package library.data;

import java.io.Serializable;
import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;

import library.LibrarySystem;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String ADT;
    private String email;
    private int currentLoans;

    // Constructors
    public User(String username, String password, String firstName, String lastName, String ADT, String email, LibrarySystem librarySystem) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ADT = ADT;
        this.email = email;
        this.currentLoans = 0;
        this.addUser(librarySystem);
    }

    // Getters and setters for all fields

    // Other methods as needed for user management

    @Override
    public String toString() {
        return "\nUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ADT='" + ADT + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void addUser(LibrarySystem librarySystem){
        librarySystem.getUsers().add(this);
    }

    public String getUsername() {
        return this.username;
    }

    // Method to modify user information
    public void modifyUser(String newUsername, String newPassword,
    String newFirstName, String newLastName, String newADT, String newEmail) {
        // Update the book information
        username = newUsername;
        password = newPassword;
        firstName = newFirstName;
        lastName = newLastName;
        ADT = newADT;
        email = newEmail;
    }

    // Constructor for user registration (signup)
    public static User registerUser(String username, String password,
            String firstName, String lastName, String ADT, String email, LibrarySystem librarySystem) {
        // Check if the username is already taken
        if (isUsernameTaken(username, librarySystem)) {
            System.out.println("Username is already taken. Please choose a different username.");
            return null;
        }

        // Create a new User object and add it to the users
        User newUser = new User(username, password, firstName, lastName, ADT, email, librarySystem);
        librarySystem.getUsers().add(newUser);

        System.out.println("User registration successful.");
        return newUser;
    }

    // Helper method to check if the username is already taken
    private static boolean isUsernameTaken(String username, LibrarySystem librarySystem) {
        for (User user : librarySystem.getUsers()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    // Method for adding comments to a borrowed book
    public void addComment(String title, String comment, LibrarySystem librarySystem) {
        Book book = librarySystem.searchBookTitle(title);
        // Check if the user has an active loan for the book
        if (hasActiveLoan(book,librarySystem)) {
            // Implement logic to add comments to a borrowed book
            book.addComment(comment);
        } else {
            System.out.println("You can only add comments to books you are actively borrowing.");
        }
    }

    // Method for adding rating to a borrowed book
    public void addRating(String title, double rating, LibrarySystem librarySystem) {
        Book book = librarySystem.searchBookTitle(title);
        // Check if the user has an active loan for the book
        if (hasActiveLoan(book,librarySystem)) {
            // Implement logic to add rating to a borrowed book
            book.addRating(rating);
        } else {
            System.out.println("You can only add ratings to books you are actively borrowing.");
        }
    }

    // Helper method to check if the user has an active loan for the book
    private boolean hasActiveLoan(Book book, LibrarySystem librarySystem) {
        for (Loan loan : librarySystem.getLoans()) {
            if (loan.getUser().equals(this) && loan.getBook().equals(book)) {
                return true;
            }
        }
        return false;
    }

    public void borrowBook(String title, LibrarySystem librarySystem) {
        Book book = librarySystem.searchBookTitle(title);
        // Check if the user has reached the maximum limit of books to borrow
        if (currentLoans < 2) {
            // Check if there are available copies of the book
            if (book.getAvailableCopies() > 0) {
                // Update the book and user information
                book.borrowBook();
                currentLoans++;

                // Create a new loan for the user
                LocalDate currentDate = LocalDate.now();
                LocalDate returnDate = currentDate.plusDays(5);

                Loan newLoan = new Loan(book, this, currentDate, returnDate);
                
                // Add the loan to the loans list
                librarySystem.getLoans().add(newLoan);
                   
            }else {
                System.out.println("Sorry, no available copies of the book.");
            }
        } else {
                System.out.println("You have reached the maximum limit of books to borrow (2).");
        }
    }

    // public Book searchBookTitle(String title, LibrarySystem librarySystem) {
    //     return librarySystem.searchBookTitle(title);
    // }

    // public void searchAndPrintBookByTitle(String title, LibrarySystem librarySystem) {
    //     Book foundBook = librarySystem.searchBookTitle(title);

    //     if (foundBook != null) {
    //         System.out.println("Book found:");
    //         System.out.println(foundBook.toString());
    //     } else {
    //         System.out.println("Book not found.");
    //     }
    // }

    // public Book searchBookAuthor(String author, LibrarySystem librarySystem) {
    //     return librarySystem.searchBookAuthor(author);
    // }

    // public Book searchBookYear(int yearOfPublication, LibrarySystem librarySystem) {
    //     return librarySystem.searchBookYear(yearOfPublication);
    // }

    // Method to search for a book based on title, author, and year of publication
    public Book searchBook(String title, String author, Integer yearOfPublication, LibrarySystem librarySystem) {
        return librarySystem.searchBook(title, author, yearOfPublication);
    }

    public void searchAndPrintBook(String title, String author, Integer yearOfPublication, LibrarySystem librarySystem) {
        Book foundBook = librarySystem.searchBook(title, author, yearOfPublication);
    
        if (foundBook != null) {
            System.out.println("Book found:");
            System.out.println(foundBook.toString());
        } else {
            System.out.println("Book not found.");
        }
    }
}
