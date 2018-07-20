package com.bibliojavaepsi.model;

import com.bibliojavaepsi.LibraryInterface;
import com.bibliojavaepsi.exception.LibraryException;

import java.util.*;

/**
 *Library class
 * host a Book and a User List
 * and
 * all associated methods
 */
public class Library implements LibraryInterface
    {
        /**
         * The books in the library
         */
        private final List<Book> Books = new ArrayList<>();
        /**
         * allows to keep record of every registered users in the library
         */
        private final List<User> Users = new ArrayList<>();

        /**
         * get's the desired user from the users list of the library
         * @param username
         * @return a User that match the username
         */
        public User getUser(String username)
            {
                return Users.stream()
                        .filter(user -> user.getName().contains(username))
                        .findFirst()
                        .orElse(null);
            }

        /**
         * get a book from the bool list of the library
         * @param id the id of the wanted book
         * @return
         */
        @Override
        public Book getBook(final String id)
            {
                return Books.stream().filter(book -> book.getId().contains(id)).findFirst().orElse(null);
            }

        /**
         * adds a book to the library's books list
         * @param isbn the ISBN
         * @return a boolean that tells if the book as been added or not
         */
        @Override
        public boolean addBook(final String isbn)
            {
                return Books.add(new Book(isbn));
            }

        /**
         * check if the wanted book is available and adds it to the user for which the username has been passed has parameter
         * @param id       the id of the borrowed book
         * @param username the name of the user
         * @throws LibraryException if the book cannot be borrowed
         */
        @Override
        public void borrowBook(final String id, final String username) throws LibraryException
            {
                User theUser = new User();


                for (User aUser: Users)
                    {
                        if(aUser.getName().equals(username))
                            theUser = aUser;
                        else throw new LibraryException("Cant find the desired user");
                    }
                for (Book aBook: Books)
                    {
                        if(aBook.getId().equals(id))
                            {
                                if(aBook.getQuantity() <= 0)
                                    {
                                        throw new LibraryException("There are no more copies of this book");
                                    }
                                else aBook.setQuantity(aBook.getQuantity()-1);
                                theUser.getBorrowedBooks().add(aBook);
                            }
                        else  throw new LibraryException("Cant add the desired book to the user's borrowed books list");
                    }
            }

        /**
         * returns a book to the library from the borrowed book list in the user's property
         * @param id       the id of the book to borrow
         * @param username the name of the user
         * @throws LibraryException if the book cannot be returned
         */
        @Override
        public void returnBook(final String id, final String username) throws LibraryException
            {
                User theUser = new User();
                for (User aUser: Users)
                    {
                        if(aUser.getName().equals(username))
                            theUser = aUser;
                        else throw new LibraryException("Cant find the desired user");
                    }
                for (Book aBook: theUser.getBorrowedBooks())
                    {
                        if(aBook.getId().equals(id))
                            {
                                if(aBook.getQuantity() <= 0)
                                    {
                                        throw new LibraryException("this user did not borrow that book");
                                    }
                                else
                                    {
                                        theUser.getBorrowedBooks().remove(aBook);
                                    }
                            }
                        else throw new LibraryException("can't return the book to the library");
                    }
            }

        /**
         * Returns a lits of books according to the search parameter
         * @return a list of Books that matches the searched for terms
         */
        @Override
        public List<Book> getBooks()
            {
                return Books;
            }

        /**
         * returns a list of all books matching the searched term
         * @param searchTerm the searched term
         * @return
         */
        @Override
        public List<Book> searchBooks(final String searchTerm)
            {
                List<Book> searchedBooks = new ArrayList<>();
                for (Book aBook: searchedBooks)
                    {
                        if(match(aBook,searchTerm))
                            {
                                searchedBooks.add(aBook);
                            }
                    }
                return searchedBooks.subList(0,9);
            }

        /**
         * returns if the book matches the search parameter
         * @param aBook Book
         * @param searchTerm
         * @return True (book matches teh searc term) or False (it doesn't)
         */
        private boolean match(final Book aBook, final String searchTerm)
            {
                if (aBook.getTitle().equals(searchTerm))
                    {
                        return true;
                    }
                if (aBook.getId().equals(searchTerm))
                    {
                        return true;
                    }
                if (aBook.getAuthor().equals(searchTerm))
                    {
                        return true;
                    }
                return false;
            }
    }
