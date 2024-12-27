# 📚 Library Management System

## ✨ Overview
This application implements a Library Management System for IIITD using Object-Oriented Programming (OOP) principles. It provides functionalities for both librarians and members to manage and interact with the library system effectively.

## ⚖️ Features
- **📖 Librarian functionalities**:
  1. ➕ Add books.
  2. ❌ Remove books.
  3. 🔖 Register members.
  4. 🔒 Remove members.
  5. 🔍 View all members and their details (including books borrowed and fines).
  6. 🔊 View all available books.
- **👨‍🎓 Member functionalities**:
  1. 🔎 View available books.
  2. 📚 Borrow books (up to 2 books at a time).
  3. ⬅️ Return books (with automatic fine calculation if overdue).
  4. 📑 View borrowed books.
  5. ⚖️ Pay fines.
- **⚙️ General functionalities**:
  1. 🔄 Menu-driven interface.
  2. ⚠️ Input validation and error handling.
  3. ₹ Fine calculation for overdue books (3 rupees per day).

## 🔧 Prerequisites
- 🔧 Java Development Kit (JDK) installed.
- 🔧 Apache Maven installed.
- 🎨 IDE or text editor for Java programming.

## 🗂 File Structure
```
|-- src
|   |-- main
|   |   |-- java
|   |   |   |-- library
|   |   |       |-- Main.java
|   |   |       |-- Library.java
|   |   |       |-- Librarian.java
|   |   |       |-- Member.java
|   |   |       |-- Book.java
|-- pom.xml
|-- README.md
```

## ⚡ Setup and Execution
### Step 1: 🔧 Clone the Repository
1. Download or clone the repository containing the project files.

### Step 2: ⛱ Navigate to the Project Directory
Ensure that the project directory contains the `pom.xml` file.

### Step 3: 🔨 Build the Project
Run the following command to compile the project and resolve dependencies:
```
mvn clean install
```

### Step 4: ▶️ Run the Application
Execute the application using the following command:
```
mvn exec:java -Dexec.mainClass="library.Main"
```

## 🔍 Usage
### 🔄 Starting the Application
1. Upon running, you will see the main menu with options to enter as a librarian, enter as a member, or exit the application.
2. Navigate through the menus by entering the corresponding option numbers.

### 📖 Librarian Operations
- 🔖 Register members by providing their name, age, and phone number.
- ➕ Add books with details like title, author, and the number of copies.
- ❌ Remove books or members using their IDs.
- 🔍 View all registered members along with their borrowed books and fines.
- 🔊 View the list of all available books in the library.

### 👨‍🎓 Member Operations
- 🔎 Log in using your registered name and phone number.
- 🔎 View the list of available books.
- 📚 Borrow books (ensure no pending fines and limit of 2 books).
- ⬅️ Return borrowed books and pay fines if overdue.
- 📑 View your borrowed books and fines.

### ⏹ Exiting the Application
Select the `Exit` option to terminate the application gracefully.

## ❓ Assumptions
- ⏳ A due date for all books is 10 days after the issue date.
- ₹ Fine calculation is 3 rupees per day after the due date.
- ➕ A member can borrow up to 2 books at a time.
- 🔑 Book IDs and Member IDs are auto-generated and unique.
- 🔍 Phone numbers act as unique identifiers for members.

## ⚠️ Error Handling
- ⚠️ Invalid inputs are handled with error messages.
- ⚠️ Attempting to log in as a non-existent member will show an error message.
- ⚠️ Borrowing a book when no copies are available or when fines are unpaid will display appropriate messages.

## 🌀 Sample Execution
Refer to the **SAMPLE RUN** provided in the project instructions for a detailed walkthrough of the application’s flow.

## 📢 Submission Guidelines
1. ✅ Ensure all project files, including the `pom.xml` and the compiled classes, are included.
2. 🗃️ The submission should be a zipped folder named in the format: `A1_RollNumber.zip`.
3. ⚡ Verify that the `mvn clean install` command successfully compiles the project.
4. 🔖 Include this README file in your submission.

## 📢 Contact
For any issues or queries related to the project, please contact me.

🌈 Happy Coding!
