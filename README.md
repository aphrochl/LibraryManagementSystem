# Library Management System
### Multimedia Technology ECE NTUA 2023-2024
#### Graded 7/10

## Creator

 
 
 **Afroditi Marianthi Chlapani [el20889@mail.ntua.gr](https://github.com/ntua-el20889)**   

---

## Project Overview

This project implements a **Library Management System** that allows administrators to manage books, categories, users, and loans, while users can search, borrow, and rate books. The system handles both the backend logic and data storage using Java, with future support for a graphical user interface (GUI) via JavaFX. Currently, the project is operated via the terminal.

Key features:
- Administrator capabilities: Add, delete, and modify books and categories. Manage user data and open book loans.
- User functionality: Search for books, borrow and return them, and rate or comment on borrowed material.
- Loan management: Administrators can track active loans, and users can view their own active loans.
- Data persistence: Utilizes Java serialization to store and retrieve application data between sessions.
- Basic terminal interface: The system is controlled through terminal commands, allowing interaction with the library system via a text-based interface.

---

# Contents

- [Prerequisites](#Prerequisites)
- [How to Compile and Run](#How-to-Compile-and-Run)
- [Usage Instructions](#Usage-Instructions)
- [Application Features](#Application-Features)
- [Project Assumptions](#Project-Assumptions)
- [Known Issues](#Known-Issues)
- [References](#References)


## Prerequisites

To run this project, you will need:

- Java Development Kit (JDK) 8 or higher: [Install JDK](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
- IDE such as IntelliJ IDEA, Eclipse, or any Java-supporting IDE.

## How to Compile and Run

### Compilation
From the project directory, open a terminal and run the following commands to compile the project:
```sh
javac -d bin src/library/*.java src/library/data/*.java src/library/management/*.java src/library/gui/*.java src/test/*.java src/test/util/*.java
```
## Running the Application
To run the project, use the following command:
```sh
java -cp bin library.LibrarySystem
```
The program will start with pre-populated data (administrators, users, books) from `test/PopulateLibrarySystem.java`.

## Usage Instructions

Once the program is running, use the following login details to explore the system:

- **Admin 1**: Username: `medialab`, Password: `medialab_2024`
- **Admin 2**: Username: `afro`, Password: `12345`
- **User 1**: Username: `Username1`, Password: `Password1`

### Administrator Commands
- Add, modify, or delete books and categories.
- Manage users and book loans.

### User Commands
- Register a new user.
- Search for books by title, author, or year of publication.
- Borrow and return books, and add comments and ratings.

---

## Application Features

- **Data Persistence**: The system saves its state using Java object serialization, allowing it to retrieve and store application data across sessions.
- **Book Management**: Administrators can add, edit, or remove books, and manage book categories.
- **User Management**: Users can register, search for books, borrow them, and add ratings or comments to borrowed items.
- **Loan Management**: Administrators track open loans and return books, updating the number of available copies.

---

## Project Assumptions

- A new category is created when a book is added with a non-existing category.
- ISBN cannot be modified after adding a book.

---

## Known Issues

- The GUI (Graphical User Interface) has not been fully implemented. The system is currently controlled entirely from the terminal.
- No validation for ISBN format or email validation during user registration.





