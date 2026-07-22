package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    private String injectionMessage;

    public BookService() {}

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.injectionMessage = "Injected via CONSTRUCTOR!";
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.injectionMessage = "Injected via SETTER!";
    }

    public void addBook(String title) {
        System.out.println("BookService Status: " + injectionMessage);
        if (bookRepository != null) {
            bookRepository.saveBook(title);
        } else {
            System.out.println("Error: BookRepository is null!");
        }
    }
}