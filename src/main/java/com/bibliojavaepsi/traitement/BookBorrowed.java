package com.bibliojavaepsi.traitement;

import com.bibliojavaepsi.model.Book;

public class BookBorrowed {
    private Book book;
    private String username;

    public BookBorrowed(Book book, String username) {
        this.book = book;
        this.username = username;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
