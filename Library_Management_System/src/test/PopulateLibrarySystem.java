package test;

import java.io.Serializable;
import java.util.ArrayList;

import library.LibrarySystem;
import library.data.Book;
import library.data.Category;
import library.data.Loan;
import library.data.User;
import library.management.Admin;
import test.util.SerializationUtils;

public class PopulateLibrarySystem implements Serializable{

    public static void main(String[] args) {   
        // Create test data
        LibrarySystem librarySystem = new LibrarySystem(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        Admin admin1 = new Admin("medialab", "medialab_2024", librarySystem);
        Admin admin2 = new Admin("afro", "12345", librarySystem);

        User user1 = new User("Username1", "Password1", "FirstName1", "LastName1", "ADT1", "email1@example.com", librarySystem);
        User user2 = new User("Username2", "Password2", "FirstName2", "LastName2", "ADT2", "email2@example.com", librarySystem);
        User user3 = new User("Username3", "Password3", "FirstName3", "LastName3", "ADT3", "email3@example.com", librarySystem);
        
        admin1.addBook("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565", "Scribner", 1925, 3, "Classic", librarySystem);
        admin1.addBook("To Kill a Mockingbird", "Harper Lee", "978-0061120084", "Harper Perennial Modern Classics", 1960, 2, "Fiction", librarySystem);
        admin1.addBook("1984", "George Orwell", "978-0451524935", "Signet Classic", 1949, 4, "Dystopian", librarySystem);
        admin1.addBook("The Hobbit", "J.R.R. Tolkien", "978-0345339683", "Del Rey", 1937, 5, "Fantasy", librarySystem);
        admin1.addBook("The Catcher in the Rye", "J.D. Salinger", "978-0241950432", "Penguin Books", 1951, 3, "Coming-of-Age", librarySystem);

        user1.borrowBook("The Great Gatsby", librarySystem);

        System.out.println(librarySystem.toString() + "\n");


        String basePath = "C:/Users/Αφροδίτη/tp/Library_Management_System/src/test/medialab/";

        // Serialize LibrarySystem
        SerializationUtils.serializeObject(librarySystem, basePath + "librarySystem.ser");

    }
}
