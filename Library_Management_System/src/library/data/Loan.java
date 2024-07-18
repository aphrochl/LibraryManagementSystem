package library.data;

import java.io.Serializable;
import java.time.LocalDate;
// import java.util.Date;


public class Loan implements Serializable {
    private static final long serialVersionUID = 1L;

    private Book book;
    private User user;
    private LocalDate starDate;
    private LocalDate returnDate;

    // Constructors
    public Loan(Book book, User user, LocalDate starDate, LocalDate returnDate) {
        this.book = book;
        this.user = user;
        this.starDate = starDate;
        this.returnDate = returnDate;
    }

    // Getters and setters for all fields

    // Other methods as needed for loan management

    @Override
    public String toString() {
        // Override toString for convenient display of loan information
        return "Loan {\n" +
                "Book = " + book +
                "\n, User=" + user +
                "\n, StartDate=" + starDate +
                "\n, returnDate=" + returnDate +
                '}';
    }

    public Book getBook() {
        return this.book;
    }

    public User getUser() {
        return this.user;
    }
}
