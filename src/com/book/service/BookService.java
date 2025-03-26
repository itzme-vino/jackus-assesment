package com.book.service;

import com.book.model.Book;

import java.util.List;

public interface BookService {
    String addBook(Book book);
    List<Book> getAllBooks();
    Book getBookByID(Integer id);
    Book getBookByTitle(String title);
    String updateBook(Book book);
    String deleteBook(String title);
}
