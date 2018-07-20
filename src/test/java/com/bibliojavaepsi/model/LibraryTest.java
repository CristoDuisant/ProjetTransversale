package com.bibliojavaepsi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest
    {
		Library lib = new Library();
		lib.addBook("1234567890");
        @org.junit.jupiter.api.Test
        void getUser()
            {
        		assertEquals(1, lib.size());
            }
        
        @Test
        void getBook()
            {
        		assertEquals(1, lib.size());
            }

        @Test
        void addBook()
            {
    		List<Book> theBooks = lib.getBooks();
    		assertEquals(1, theBooks.size());
    		assertEquals("1234567890", theBooks.get(0).getIsbn10());
            }

        @Test
        void borrowBook()
            {
            }

        @Test
        void returnBook()
            {
            }

        @Test
        void getBooks()
            {
        		assertEquals("1234567890", lib.getBooks());
            }

        @Test
        void searchBooks()
            {
            }

    }
