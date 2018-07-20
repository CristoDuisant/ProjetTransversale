package com.bibliojavaepsi;
import com.bibliojavaepsi.model.Book;
import com.bibliojavaepsi.exception.LibraryException;
import java.util.List;

/**
 * Interface that defines the necessary contract for a library
 */
public interface LibraryInterface {
    /**
     * Get a book from its id
     *
     * @param id the id of the wanted book
     * @return a book with the given id if there is one
     */
    Book getBook(String id);
    /**
     * Add a book with the given ISBN
     *
     * @param isbn the ISBN
     * @return the id of the added book if the isbn exists
     */
    boolean addBook(String isbn);
    /**
     * Borrow a book from the library
     *
     * @param id the id of the borrowed book
     * @param username the name of the user
     * @throws LibraryException if no book in the library has the given id
     * @throws LibraryException if all books in the library with the given id
    have been borrowed
     */
    void borrowBook(String id, String username) throws LibraryException;
    /**
     * Return a book back to the library
     *
     * @param id the id of the book to borrow
     * @param username the name of the user
     * @throws LibraryException if no book in the library has the given id
     * @throws LibraryException if all books with the given id are
    already returned
     */
    void returnBook(String id, String username) throws LibraryException;
    /**
     * Get all books of the library
     *
     * @return the books
     */
    List<Book> getBooks();
    /**
     * Return all books with an author, a title or an ISBN matching the search term
     *
     * @param searchTerm the searched term
     * @return the books matching the search term
     */
    List<Book> searchBooks(String searchTerm);

}
