Digital Library Book Management System
A simple Library Management System to manage books, allowing users to add, search, update, and delete books.

🔹 Features
✔ Add new books to the system
✔ View all available books
✔ Search for a book by ID or Title
✔ Update book details
✔ Delete books
✔ Track availability status (AVAILABLE / CHECKED_OUT)

🔹 Technologies Used
Java (Core Java)
Git for version control

🔹 Setup Instructions

1️⃣ Clone the repository

git clone https://github.com/itzme-vino/jackus-assesment.git

2️⃣ Navigate to the project folder
cd jackus-assesment

3️⃣ Compile and run the application

javac LibraryBookManagementApplication.java
java LibraryBookManagementApplication

🔹 Usage

📌 Adding a Book
Enter your choice: 1
Enter Book Title: rust
Enter Author Name: me
Enter Genre: fiction
Enter Availability (AVAILABLE / CHECKED_OUT): available
Book added successfully

📌 Searching a Book by ID
Enter your choice: 3
Enter Book ID: 1
Book Details:
ID: 1
Title: rust
Author: me
Genre: fiction
Availability: AVAILABLE

📌 Searching a Book by Title
Enter your choice: 4
Enter Book Title: rust
Book Details:
ID: 1
Title: rust
Author: me
Genre: fiction
Availability: AVAILABLE
Enter your choice: 2

📌 Visiting all books
 Book List
Book Id:1
Title: rust
Author me
Genre: fiction
Availability: AVAILABLE

📌 Updated books
Enter your choice: 5
Enter Book ID to Update: 1
Enter New Title: rust new
Enter New Author: new
Enter New Genre: love
Enter New Availability (AVAILABLE / CHECKED_OUT): checkedout
Invalid status! Defaulting to AVAILABLE.
Book updated successfully

📌 Deleting a Book
Enter your choice: 6
Enter Book Title to Delete: rust new

Book deleted successfully

📌 Deleting a Book by unexisted title
Enter your choice: 6
Enter Book Title to Delete: unexisted
Book with title 'unexisted' not found

📌 Exiting the system
7. Exit
Enter your choice: 7
Exiting the system