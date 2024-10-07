# Library Management System
### Multimedia Technology ECE NTUA 2023-2024
#### Graded 7/10

## Creator

 
 
 **Afroditi Marianthi Chlapani [github](https://github.com/aphrochl)**   

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
