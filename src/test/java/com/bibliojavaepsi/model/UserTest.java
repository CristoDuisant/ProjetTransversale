package com.bibliojavaepsi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest
    {
		private User user = new User("1", "Michel", "michel@test.com", "Lille");
		

        @org.junit.jupiter.api.Test
        void getId()
            {
                assertEquals("1", user.getId());
            }

        @org.junit.jupiter.api.Test
        void setId()
            {
                user.setId("2");
                assertEquals("2", user.getId());
            }

        @org.junit.jupiter.api.Test
        void getName()
            {
        		assertEquals("Michel", user.getName());
            }

        @org.junit.jupiter.api.Test
        void setName()
            {
        		user.setName("Jean");
        		assertEquals("Jean", user.getName());
            }

        @org.junit.jupiter.api.Test
        void getEmail()
            {
                assertEquals("michel@test.com", user.getEmail());
            }

        @org.junit.jupiter.api.Test
        void setEmail()
            {
                user.setEmail("michel@gmail.com");
                assertEquals("michel@gmail.com", user.getEmail());
            }
        
        @org.junit.jupiter.api.Test
        void getAddress()
            {
                assertEquals("Lille", user.getAddress());
            }

        @org.junit.jupiter.api.Test
        void setAddress()
            {
                user.setAddress("Hardelot");
                assertEquals("Hardelot", user.getAddress());
            }
        @Test
        void getBorrowedBooks()
            {
            }

        @Test
        void setBorrowedBooks()
            {
            }

    }
