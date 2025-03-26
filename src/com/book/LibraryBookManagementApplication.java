package com.book;

import com.book.controller.BookController;
import com.book.model.Book;
import com.book.service.BookService;
import com.book.service.BookServiceImpl;
import com.book.model.AvailabilityStatus;

import java.util.List;
import java.util.Scanner;

public class LibraryBookManagementApplication
{
    private final BookController bookController;

    public LibraryBookManagementApplication(BookController controller)
    {
        this.bookController = controller;
    }

    public static void main(String[] args)
    {
        BookService bookService = new BookServiceImpl();
        BookController bookController = new BookController(bookService);
        LibraryBookManagementApplication app = new LibraryBookManagementApplication(bookController);
        app.start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n Digital Library Book Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Search Book by Title");
            System.out.println("5. Update Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addBook(scanner);
                case 2 -> viewAllBooks();
                case 3 -> searchBookByID(scanner);
                case 4 -> searchBookByTitle(scanner);
                case 5 -> updateBook(scanner);
                case 6 -> deleteBook(scanner);
                case 7 -> {
                    System.out.println("Exiting the system");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addBook(Scanner scanner)
    {
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Availability (AVAILABLE / CHECKED_OUT): ");
        String status = scanner.nextLine().toUpperCase();

        AvailabilityStatus availabilityStatus;
        try
        {
            availabilityStatus = AvailabilityStatus.valueOf(status);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid availability status! Defaulting to AVAILABLE.");
            availabilityStatus = AvailabilityStatus.AVAILABLE;
        }

        Book book = new Book(title, author, genre, availabilityStatus);
        System.out.println(bookController.addBook(book));
    }

    private void viewAllBooks()
    {
        System.out.println("\n Book List");
        List<Book> bookList = bookController.getAllBooks();
        if(!bookList.isEmpty()) {
            for (Book book : bookList) {
                System.out.println("Book Id:" + book.getBookId() + "\nTitle: " + book.getTitle()
                        + "\nAuthor " + book.getAuthor() + "\nGenre: " + book.getGenre()
                        + "\nAvailability: " + book.getAvailabilityStatus());
            }
        }
        else {
            System.out.println("Library doesn't have any books");
        }
    }

    private void searchBookByID(Scanner scanner) {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Book book = bookController.getBookByID(id);

        if (book != null) {
            System.out.println("Book Details:");
            System.out.println("ID: " + book.getBookId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Genre: " + book.getGenre());
            System.out.println("Availability: " + book.getAvailabilityStatus());
        }
//        else {
//            System.out.println("Book not found.");
//        }
    }

    private void searchBookByTitle(Scanner scanner)
    {
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        Book book = bookController.getBookByTitle(title);

        if (book != null)
        {
            System.out.println("Book Details:");
            System.out.println("ID: " + book.getBookId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Genre: " + book.getGenre());
            System.out.println("Availability: " + book.getAvailabilityStatus());
        }
//        else
//        {
//            System.out.println("Book not found.");
//        }
    }

    private void updateBook(Scanner scanner)
    {
        System.out.print("Enter Book ID to Update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter New Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter New Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter New Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter New Availability (AVAILABLE / CHECKED_OUT): ");
        String status = scanner.nextLine().toUpperCase();

        AvailabilityStatus availabilityStatus;
        try
        {
            availabilityStatus = AvailabilityStatus.valueOf(status);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid status! Defaulting to AVAILABLE.");
            availabilityStatus = AvailabilityStatus.AVAILABLE;
        }

        Book book = new Book(title, author, genre, availabilityStatus);
        book.setBookId(id);
        System.out.println(bookController.updateBook(book));
    }

    private void deleteBook(Scanner scanner)
    {
        System.out.print("Enter Book Title to Delete: ");
        String title = scanner.nextLine();
        System.out.println(bookController.deleteBook(title));
    }
}
