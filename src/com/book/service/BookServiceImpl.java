package com.book.service;

import com.book.exception.BookNotFoundException;
import com.book.model.Book;

import java.util.*;

public class BookServiceImpl implements BookService
{
    private List<Book> bookList = new ArrayList<>();
    private static Integer bookId = 0;

    @Override
    public String addBook(Book book)
    {
        Book newBook = new Book();
        newBook.setBookId(++bookId);
        newBook.setAuthor(book.getAuthor());
        newBook.setTitle(book.getTitle());
        newBook.setGenre(book.getGenre());
        newBook.setAvailabilityStatus(book.getAvailabilityStatus());
        bookList.add(newBook);
        return "Book added successfully";
    }

    public List<Book> getAllBooks()
    {
        return bookList;
    }

    public Book getBookByID(Integer bookId)
    {
        return bookList.stream()
                .filter(b -> b.getBookId().equals(bookId))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + bookId + " not found"));
    }

    public Book getBookByTitle(String title)
    {
        return bookList.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book with title '" + title + "' not found"));
    }

    public String updateBook(Book book)
    {
        Integer updateBookId = book.getBookId();
        Book updateBook = getBookByID(updateBookId);

        updateBook.setAuthor(book.getAuthor());
        updateBook.setTitle(book.getTitle());
        updateBook.setGenre(book.getGenre());
        updateBook.setAvailabilityStatus(book.getAvailabilityStatus());

        return "Book updated successfully";
    }

    public String deleteBook(String title)
    {
        Book book = getBookByTitle(title);
        bookList.remove(book);
        return "Book deleted successfully";
    }
}
