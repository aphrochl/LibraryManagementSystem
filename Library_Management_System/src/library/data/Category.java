package library.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private List<Book> books; // Assuming each category contains a list of books

    // Constructors
    public Category(String title) {
        this.title = title;
        this.books = new ArrayList<>();
    }

    // Getters and setters for all fields

    // // Method for adding a book to the category
    // public void addBook(Book book) {
    //     books.add(book);
    // }

    // // Other methods as needed for category management

    
    public void modifyCategory(String newTitle) {
        // Update the category
        title = newTitle;
    }

    @Override
    public String toString() {
        // Override toString for convenient display of category information
        return "\nCategory {" +
                "   title='" + title + '\'' +
                ",\nbooks=" + books +
                '}';
    }


    public String getTitle() {
        return this.title;
    }

    public List<Book> getBooks() {
        return this.books;
    }
}
