# Report

This directory contains the Report for the Library Management System project. 

It is written in greek, so below is the main information included.

# Contents

- [Usage Instructions](#Usage-Instructions)
- [Application Features](#Application-Features)
- [Project Assumptions](#Project-Assumptions)
- [Known Issues](#Known-Issues)

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

### Usage
- It also includes instructions on how to compile and run the code, which you can find in the [main README file](https://github.com/ntua-el20889/LibraryManagementSystem/tree/main) in the root of the repository for instructions.







