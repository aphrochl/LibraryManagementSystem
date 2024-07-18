package library;

import java.io.Serializable;
// import java.util.ArrayList;
import java.util.List;

import library.data.Book;
import library.data.Category;
import library.data.Loan;
import library.data.User;
import library.management.Admin;
import test.Deserial;
import test.PopulateLibrarySystem;

public class LibrarySystem implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Book> books;
    private List<Category> categories;
    private List<User> users;
    private List<Admin> admins;
    private List<Loan> loans;

    // Constructors
    public LibrarySystem(List<Book> books, List<Category> categories, List<User> users, List<Admin> admins, List<Loan> loans) {
        this.books = books;
        this.categories = categories;
        this.users = users;
        this.admins = admins;
        this.loans = loans;
    }

    // Getters and setters for all fields

    // Other methods as needed for library system management

    public static void main(String[] args) {
        Deserial.main(new String[]{});
        PopulateLibrarySystem.main(new String[]{});
    }


    @Override
    public String toString() {
        // Override toString for convenient display of library system information
        return "LibrarySystem {" +
                "books = " + books + ",\n" +
                "categories = " + categories + ",\n" +
                "users = " + users + ",\n" +
                "admins = " + admins + ",\n" +
                "loans = " + loans + ",\n" +
                '}';
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public Book searchBookTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // public Book searchBookAuthor(String author) {
    //     for (Book book : books) {
    //         if (book.getAuthor().equalsIgnoreCase(author)) {
    //             return book;
    //         }
    //     }
    //     return null; // Book not found
    // }

    // public Book searchBookYear(int yearOfPublication) {
    //     for (Book book : books) {
    //         if (book.getYear() == yearOfPublication) {
    //             return book;
    //         }
    //     }
    //     return null; // Book not found
    // }

    public Category searchCategory(String title) {
        for (Category category : categories) {
            if (category.getTitle().equalsIgnoreCase(title)) {
                return category;
            }
        }
        return null; // Category not found
    }

    
    public User searchUser(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null; // User not found
    }

    // Method to search for a book based on title, author, and year of publication
    public Book searchBook(String title, String author, Integer yearOfPublication) {
        for (Book book : books) {
            boolean matchesTitle = title == null || book.getTitle().equalsIgnoreCase(title);
            boolean matchesAuthor = author == null || book.getAuthor().equalsIgnoreCase(author);
            boolean matchesYear = yearOfPublication == null || book.getYear() == yearOfPublication;

            if (matchesTitle && matchesAuthor && matchesYear) {
                return book;
            }
        }
        return null; // Book not found
    }

}
