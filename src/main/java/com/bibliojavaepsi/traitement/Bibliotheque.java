package com.bibliojavaepsi.traitement;

import com.bibliojavaepsi.LibraryInterface;
import com.bibliojavaepsi.model.Book;
import com.bibliojavaepsi.model.User;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.ArrayList;
import java.util.Iterator;

public class Bibliotheque implements LibraryInterface {

    private ArrayList<Book> books = new ArrayList();
    private ArrayList<BookBorrowed> booksBorrowed = new ArrayList();
    private static Bibliotheque instance;

    private Bibliotheque() {
    }

    public static Bibliotheque getInstance() {
        if (instance == null) {
            instance = new Bibliotheque();
        }

        return instance;
    }

    public Book getBook(String id) {
        if (this.books.size() == 0) {
            return null;
        } else {
            Iterator var3 = this.books.iterator();

            while(var3.hasNext()) {
                Book book = (Book)var3.next();
                if (book.getId().equalsIgnoreCase(id)) {
                    return book;
                }
            }

            return null;
        }
    }

    public boolean existeDeja(Book bk) {
     /*   boolean i = false;
        Iterator var4 = this.books.iterator();

        while(var4.hasNext()) {
            Book book = (Book)var4.next();
            if (book.getIsbn().equalsIgnoreCase(bk.getIsbn())) {
                i = true;
                break;
            }
        }

        return i;*/

        return this.books.stream()
                .map(Book::getIsbn)
                .anyMatch(bk.getIsbn()::equalsIgnoreCase);
    }

    public String addBook(String isbn) {
        String id = null;
        User a = new User(1,"Cristofer","cristofer.duisant@epsi.fr","Lille" );
        if (this.existeDeja(B)) {
            id = Book.getId();
        } else {
            id = "Le livre a Ã©tÃ© bien ajoutÃ©";
        }

        this.books.add(Book);
        return id;
    }

    public String addBookWithBook(Book bk) {
        String id = null;
        if (this.existeDeja(bk)) {
            id = bk.getId();
        } else {
            id = "Le livre a Ã©tÃ© bien ajoutÃ©";
        }

        this.books.add(bk);
        return id;
    }

    public void borrowBook(String id, String username) throws BookNotFoundException, UnavailableBookException {
        boolean process = false;
        boolean found = false;

        for(int i = 0; i < this.books.size(); ++i) {
            if (((Book)this.books.get(i)).getId().equalsIgnoreCase(id)) {
                found = true;
                Book b = (Book)this.books.get(i);
                if (!b.isBorrowed()) {
                    b.setBorrowed(true);
                    process = true;
                    this.booksBorrowed.add(new BookBorrowed(b, username));
                    break;
                }
            }
        }

        if (!found) {
            throw new BookNotFoundException();
        } else if (!process) {
            throw new UnavailableBookException();
        }
    }

    public void returnBook(String id, String username) throws BookNotFoundException, AllBooksAlreadyReturnedException {
        boolean process = false;
        boolean found = false;

        for(int i = 0; i < this.books.size(); ++i) {
            if (((Book)this.books.get(i)).getId().equalsIgnoreCase(id)) {
                found = true;
                Book b = (Book)this.books.get(i);
                if (!b.isBorrowed()) {
                    throw new AllBooksAlreadyReturnedException();
                }

                Iterator var8 = this.booksBorrowed.iterator();

                while(var8.hasNext()) {
                    BookBorrowed bb = (BookBorrowed)var8.next();
                    if (bb.getBook().isEqualTo(b) && bb.getUsername().equalsIgnoreCase(username) && bb.getBook().isBorrowed()) {
                        b.setBorrowed(false);
                        bb.getBook().setBorrowed(false);
                        process = true;
                        break;
                    }
                }
            }
        }

        if (!found) {
            throw new BookNotFoundException();
        } else if (!process) {
            throw new AllBooksAlreadyReturnedException();
        }
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public ArrayList<BookBorrowed> getBooksBorrowed() {
        return this.booksBorrowed;
    }

    public ArrayList<Book> searchBooks(String searchTerm) {
        ArrayList<Book> results = new ArrayList();
        Iterator var4 = this.books.iterator();

        while(true) {
            Book b;
            do {
                if (!var4.hasNext()) {
                    return results;
                }

                b = (Book)var4.next();
            } while(!b.getTitle().equalsIgnoreCase(searchTerm) && !b.getIsbn().equalsIgnoreCase(searchTerm));

            results.add(b);
        }
    }
}
}
