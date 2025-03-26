package com.book.controller;

import com.book.exception.BookNotFoundException;
import com.book.model.Book;
import com.book.service.BookService;

import java.util.List;

public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService)
    {
        if (bookService == null) {
            throw new IllegalArgumentException("BookService cannot be null");
        }
        this.bookService = bookService;
    }

    public String addBook(Book book)
    {
        return bookService.addBook(book);
    }

    public List<Book> getAllBooks()
    {
        return bookService.getAllBooks();
    }

    public Book getBookByID(Integer id)
    {
        try
        {
            return bookService.getBookByID(id);
        }
        catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Book getBookByTitle(String title) {
        try
        {
            return bookService.getBookByTitle(title);
        }
        catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String updateBook(Book book)
    {
        try {
            return bookService.updateBook(book);
        } catch (BookNotFoundException e) {
            return e.getMessage();
        }
    }

    public String deleteBook(String title) {
        try {
            return bookService.deleteBook(title);
        } catch (BookNotFoundException e) {
            return e.getMessage();
        }
    }
}
