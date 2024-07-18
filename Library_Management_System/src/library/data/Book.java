package library.data;

// import java.io.IOException;
// import java.io.ObjectInputStream;
// import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    
    private String title;
    private String author;
    private String ISBN;
    private String publisher;
    private int yearOfPublication;
    private String category;
    private int numCopies;
    private double averageScore;
    private int numRatings;
    private List<String> comments; // Assuming comments are stored as strings

    // Constructors
    public Book(String title, String author, String ISBN, String publisher, int yearOfPublication,
                String category, int numCopies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
        this.category = category;
        this.numCopies = numCopies;
        this.averageScore = 0.0;
        this.numRatings = 0;
        this.comments = new ArrayList<>();
    }

    // Getters and setters for all fields
    
    // Other methods as needed for book management

    // @Override
    // public String toString() {
    //     // Override toString for convenient display of book information
    //     return "Book {" +
    //             "title='" + title + '\'' +
    //             ", author='" + author + '\'' +
    //             ", ISBN='" + ISBN + '\'' +
    //             ", category='" + category + '\'' +
    //             ", numCopies=" + numCopies +
    //             ", averageScore=" + averageScore +
    //             ", numRatings=" + numRatings +
    //             ", comments=" + comments +
    //             '}';
    // }

    @Override
    public String toString() {
        return "\nBook {" +
                " title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", publisher='" + publisher + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", category='" + category + '\'' +
                ", numCopies=" + numCopies +
                "}";
    }


    public void addRating(double userRating) {
        // Update the average score and the number of ratings based on the new user rating
        double totalScore = averageScore * numRatings;
        totalScore += userRating;
        numRatings++;
        averageScore = totalScore / numRatings;
    }

    public void addComment(String comment) {
        // Add a new comment to the list of comments
        comments.add(comment);
    }

    // Method to modify book information
    public void modifyBook(String newTitle, String newAuthor, String newPublisher,
                           int newYearOfPublication, String newCategory, int newNumCopies) {
        // Update the book information
        title = newTitle;
        author = newAuthor;
        publisher = newPublisher;
        yearOfPublication = newYearOfPublication;
        category = newCategory;
        numCopies = newNumCopies;
    }

    public int getAvailableCopies() {
        return this.numCopies;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getYear() {
        return this.yearOfPublication;
    }

    public String getCategory() {
        return this.category;
    }

    public void borrowBook() {
        if (getAvailableCopies() > 0) {
            // Decrease the number of available copies when a book is borrowed
            this.numCopies--;
        } else {
            System.out.println("Error: No available copies to borrow.");
        }
    }

    // Method to return a borrowed book
    public void returnBook() {
        // Increment the number of available copies
        this.numCopies++;
    }
}
