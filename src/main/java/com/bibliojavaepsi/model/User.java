package com.bibliojavaepsi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *User class
 * Represents a user that uses the application and all its properties
 */
@Entity
@Table(name="user_account")
public class User implements Serializable
    {
        /**
         * identification of the client in the library
         */
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private Integer id;

        /**
         * the users name
         */
        @Basic(optional= false)
        @Column(name = "name")
        private String name;

        /**
         * the user's email
         */
        @Basic(optional= false)
        @Column(name = "email")
        private String email;

        /**
         * teh user's address
         */
        @Basic(optional= false)
        @Column(name = "adress")
        private String address;

        /**
         * the list of books that the user has borrowed
         */
        private List<Book> borrowedBooks = new ArrayList<Book>();

        /**
         * get the user's email
         * @return the users email
         */
        public String getEmail()
            {
                return email;
            }

        /**
         * set the user email address
         * @param email
         */
        public void setEmail(String email)
            {
                this.email = email;
            }

        /**
         * get the user address
         * @return user address
         */
        public String getAddress()
            {
                return address;
            }

        /**
         * set the user address
         * @param address
         */
        public void setAddress(String address)
            {
                this.address = address;
            }

        /**
         * get the user's id
         * @return the user's ID
         */
        public Integer getId()
            {
                return id;
            }

        /**
         * set the user's id
         * @param id
         */
        public void setId(Integer id)
            {
                this.id = id;
            }

        /**
         * get the user's name
         * @return the user's name
         */
        public String getName()
            {
                return name;
            }

        /**
         * set the user's name according to the parameter
         * @param name
         */
        public void setName(String name)
            {
                this.name = name;
            }

        /**
         * return the list of borrowed book by the user
         * @return a list of borrowed books by the user
         */
        public List<Book> getBorrowedBooks()
            {
                return borrowedBooks;
            }

        /**
         * set the borrowed list according to the list parameter
         * @param borrowedBooks
         */
        public void setBorrowedBooks(List<Book> borrowedBooks)
            {
                this.borrowedBooks = borrowedBooks;
            }

        /**
         * empty user constructor
         */
        public User()
            {
            }

        /**
         * User constructor with an id and a name
         * @param id
         * @param name
         */
        public User(final Integer id, final String name)
            {
                this.id = id;
                this.name = name;
            }

        /**
         * User constructor with an id and a name, email, address
         * @param id
         * @param name
         * @param email
         * @param address
         */
        public User(Integer id, String name, String email, String address) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.address = address;
        }
    }
