package com.bibliojavaepsi.model;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BookTest
    {
        private Book book = new Book("1","papaNoel","101010","131313",new Date(2013),"JKR","Fantasy",2);
        @org.junit.jupiter.api.Test
        void getId()
            {
                assertEquals("1", book.getId());
            }

        @org.junit.jupiter.api.Test
        void setId()
            {
                book.setId("2");
                assertEquals("2", book.getId());
            }

        @org.junit.jupiter.api.Test
        void getTitle()
            {
        		assertEquals("papaNoel", book.getTitle());
            }

        @org.junit.jupiter.api.Test
        void setTitle()
            {
        		book.setTitle("HP");
        		assertEquals("HP", book.getTitle());
            }

        @org.junit.jupiter.api.Test
        void getDateOfPublication()
            {
        		assertEquals(new Date(2013), book.getDateOfPublication());
            }

        @org.junit.jupiter.api.Test
        void setDateOfPublication()
            {
        		book.setDateOfPublication(new Date(2014));
        		assertEquals(new Date(2014), book.getDateOfPublication());
            }

        @org.junit.jupiter.api.Test
        void getAuthor()
            {
        		assertEquals("JKR", book.getAuthor());
            }

        @org.junit.jupiter.api.Test
        void setAuthor()
            {
        		book.setAuthor("Jk Rowling");
        		assertEquals("Jk Rowling", book.getAuthor());
            }

        @org.junit.jupiter.api.Test
        void getKind()
            {
        		assertEquals("Fantasy", book.getKind());
            }

        @org.junit.jupiter.api.Test
        void setKind()
            {
        		book.setKind("Fantastique");
        		assertEquals("Fantastique", book.getKind());
            }

        @org.junit.jupiter.api.Test
        void getQuantity()
            {
        		assertEquals(2, book.getQuantity());
            }

        @org.junit.jupiter.api.Test
        void setQuantity()
            {
        		book.setQuantity(5);
        		assertEquals(5,book.getQuantity());
            }

    }
