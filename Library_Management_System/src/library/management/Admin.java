package library.management;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
// import java.util.Locale.Category;

import library.LibrarySystem;
import library.data.Book;
import library.data.Category;
import library.data.Loan;
import library.data.User;

public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    // Constructors
    public Admin(String username, String password, LibrarySystem librarySystem) {
        this.username = username;
        this.password = password;
        this.addAdmin(librarySystem);
    }

    // Getters and setters for all fields

    // Other methods as needed for admin management

    @Override
    public String toString() {
        // Override toString for convenient display of admin information
        return "\nAdmin {" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void addAdmin(LibrarySystem librarySystem){
        librarySystem.getAdmins().add(this);
    }

    // Method to add a new book to the library
    public void addBook(String title, String author, String ISBN, String publisher, 
    int yearOfPublication, int numCopies, String category, LibrarySystem librarySystem) {
        // Search for the category by title
        Category existingCategory = librarySystem.searchCategory(category);

        // If the category doesn't exist, create a new one and add it to the list
        if (existingCategory == null) {
            existingCategory = new Category(category);
            librarySystem.getCategories().add(existingCategory);
        }
        
        // Create a new Book object and add it to the books
        Book newBook = new Book(title, author, ISBN, publisher, 
        yearOfPublication, category, numCopies);
        librarySystem.getBooks().add(newBook);

        // Add the new book to the category's books list
        existingCategory.getBooks().add(newBook);
    }

    // Method to delete a book from the library
    public void deleteBook(String title, LibrarySystem librarySystem) {
        Book book = librarySystem.searchBookTitle(title);
        // Remove the corresponding loans for the deleted book
        List<Loan> loansToRemove = new ArrayList<>();

        for (Loan loan : librarySystem.getLoans()) {
            if (loan.getBook().equals(book)) {
                loansToRemove.add(loan);
            }
        }

        librarySystem.getLoans().removeAll(loansToRemove);

        // Remove the book from the list bbooks
        librarySystem.getBooks().remove(book);
    }
    
    // Method to modify book information
    public void modifyBook(Book book, String newTitle, String newAuthor, String newPublisher,
                           int newYearOfPublication, String newCategory, int newNumCopies) {
        // Delegate the modification to the Book class method
        book.modifyBook(newTitle, newAuthor, newPublisher, newYearOfPublication, newCategory, newNumCopies);
    }

    // Method to add a new category to the library
    public void addCategory(String title, LibrarySystem librarySystem) {
        // Create a new Category object and add it to the categories
        Category newCategory = new Category(title);
        librarySystem.getCategories().add(newCategory);
    }

    // Method to delete a category from the library
    public void deleteCategory(String title, LibrarySystem librarySystem) {
        Category category = librarySystem.searchCategory(title);

        if (category != null) {

            if (category.getBooks() != null && !category.getBooks().isEmpty()){
                
                // Remove books that belong to the deleted category
                List<Book> booksToRemove = new ArrayList<>();

                for (Book book : librarySystem.getBooks()) {
                    if (book.getCategory().equals(category)) {
                        // Remove the book from loans
                        List<Loan> loansToRemove = new ArrayList<>();

                        for (Loan loan : librarySystem.getLoans()) {
                            if (loan.getBook().equals(book)) {
                                loansToRemove.add(loan);
                            }
                        }

                        librarySystem.getLoans().removeAll(loansToRemove);

                        booksToRemove.add(book);
                    }
                }

                librarySystem.getBooks().removeAll(booksToRemove);
            }
        
            // Remove the category from the list of categories
            librarySystem.getCategories().remove(category);
        }
    }


    // Method to modify category information
    public void modifyCategory(Category category, String newTitle) {
        // Delegate the modification to the Category class method
        category.modifyCategory(newTitle);
    }

    // Method to delete a user from the library
    public void deleteUser(String username, LibrarySystem librarySystem) {
        User user = librarySystem.searchUser(username);

        // Remove the user's loans from the list
        List<Loan> loansToRemove = new ArrayList<>();

        for (Loan loan : librarySystem.getLoans()) {
            if (loan.getUser().equals(user)) {
                loansToRemove.add(loan);

                // Increment the number of copies for the book associated with the loan
                Book borrowedBook = loan.getBook();
                if (borrowedBook != null) {
                    borrowedBook.returnBook();
                }
            }
        }

        librarySystem.getLoans().removeAll(loansToRemove);

        // Remove the user with the same username from the list
        librarySystem.getUsers().remove(user);
    }


    // Method to modify category information
    public void modifyUser(User user, String newADT, String newUsername, String newPassword,
    String newFirstName, String newLastName, String newEmail) {
        // Delegate the modification to the Category class method
        user.modifyUser(newADT, newUsername, newPassword,newFirstName, newLastName, newEmail);
    }

    // Method to view all open book borrowings
    public void viewLoans(LibrarySystem librarySystem) {
        List<Loan> openLoans = librarySystem.getLoans();

        if (openLoans.isEmpty()) {
            System.out.println("No open book borrowings at the moment.");
        } else {
            System.out.println("Open Book Borrowings:");
            for (Loan loan : openLoans) {
                System.out.println(loan); 
            }
        }
    }

    // // Method to terminate the borrowing of a book
    // public void terminateLoan(String title, LibrarySystem librarySystem) {
    //     Book book = librarySystem.searchBookTitle(title);

    //     if (book != null) {
    //         List<Loan> loansToRemove = new ArrayList<>();

    //         for (Loan loan : librarySystem.getLoans()) {
    //             if (loan.getBook().equals(book)) {
    //                 loansToRemove.add(loan);

    //                 // Increment the number of copies for the returned book
    //                 book.returnBook();
    //             }
    //         }

    //         librarySystem.getLoans().removeAll(loansToRemove);
    //         System.out.println("Book borrowing terminated successfully.");
    //     } else {
    //         System.out.println("Book not found. Unable to terminate borrowing.");
    //     }
    // }

    // Method to terminate the borrowing of a book for a specific user
    public void terminateLoan(String title, String username, LibrarySystem librarySystem) {
        Book book = librarySystem.searchBookTitle(title);
        User user = librarySystem.searchUser(username);

        if (book != null && user != null) {
            Loan loanToRemove = null;

            for (Loan loan : librarySystem.getLoans()) {
                if (loan.getBook().equals(book) && loan.getUser().equals(user)) {
                    loanToRemove = loan;

                    // Increment the number of copies for the returned book
                    book.returnBook();
                }
            }

            if (loanToRemove != null) {
                librarySystem.getLoans().remove(loanToRemove);
                System.out.println("Book borrowing terminated successfully.");
            } else {
                System.out.println("Loan not found for the specified book and user. Unable to terminate borrowing.");
            }
        } else {
            System.out.println("Book or user not found. Unable to terminate borrowing.");
        }
    }
}
