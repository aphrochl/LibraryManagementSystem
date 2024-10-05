Here there are the project directions as given by the professor, colourcoded by me, for the needs of the project (for me to know which java class is assigned which function/requirement).

# Project Directions Overview

This document summarizes the project requirements for the Library Management System, along with the corresponding Java classes responsible for implementing each functionality.

### Requirements and Corresponding Classes

#### **1. Application Description**
- **Functionality**: Electronic library system for managing books and user interactions.
- **Responsible Classes**: 
  - `LibrarySystem.java`
  - `Admin.java`
  - `User.java`

#### **2. Logic Design and Implementation**
- **Functionality**: 
  - **Administrator Functions**: 
    - Manage books (add, delete, modify) - `Book.java`
    - Manage categories (add, delete, modify) - `Category.java`
    - Manage user data (delete and modify) - `User.java`
    - Manage loans - `LoanManager.java`
  - **User Functions**:
    - Registration - `User.java`
    - Search for material - `Search.java`
    - Loan of books - `Loan.java`
  
#### **3. Saving and Retrieving Application Information**
- **Functionality**: Serialize and deserialize application data.
- **Responsible Classes**:
  - `Deserial.java`
  - `Serialize.java`
  
#### **4. Creating a GUI**
- **Functionality**: Develop a graphical user interface using JavaFX.
- **Responsible Classes**:
  - `MainUI.java`
  - `LoginUI.java`
  - `AdminUI.java`
  - `UserUI.java`
  
#### **5. Other Requirements**
- **Functionality**: Follow OOP design principles and document public methods using Javadoc.
- **Responsible Classes**:
  - All classes should adhere to this requirement.

### Notes
- Each class contains the necessary methods to fulfill the specified functionalities. Review the individual classes for detailed implementations and assumptions.
