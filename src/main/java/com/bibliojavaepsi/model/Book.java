package com.bibliojavaepsi.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Book class
 * represents a book in a library
 */
@Entity
@Table(name="Book")
public class Book implements Serializable {
    /**
     * allow identification of the book inside the library
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 10)
    private String id;

    /**
     * book's title
     */
    @Basic(optional= false)
    @Column(name = "title")
    private String title;

    @Basic(optional= false)
    @Column(name = "ISBN")
    private String ISBN;

    /**
     * allows to give a kind to the book ( novel, drama, sci-fi etc...)
     */
    @Basic(optional= false)
    @Column(name = "kind")
    private String kind;

    /**
     * the author's name
     */
    @Basic(optional= false)
    @Column(name = "author")
    private String author;

    /**
     * allows to keep a record of the availability of the book in the library, also for logistic
     */
    @Basic(optional= false)
    @Column(name = "quantity")
    private int quantity;

    /**
     * when was the book published
     */
    @Basic(optional= false)
    @Column(name = "dateOfPublication")
    private Date dateOfPublication;

    /**
     * get the book's ID
     * @return the book's ID
     */
    public String getId()
        {
            return id;
        }

    /**
     * set the book's ID
     * @param id
     */
    public void setId(String id)
        {
            this.id = id;
        }

    /**
     * get the book's title
     * @return the book's title
     */
    public String getTitle()
        {
            return title;
        }

    /**
     * returns the book's ISBN
     * @return
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * set the book's title
     * @param title
     */
    public void setTitle(String title)
        {
            this.title = title;
        }

    /**
     * get the book's publication dateOfPublication
     * @return the book's publication dateOfPublication
     */
    public Date getDateOfPublication()
        {
            return dateOfPublication;
        }

    /**
     * set the book's publication dateOfPublication
     * @param dateOfPublication
     */
    public void setDateOfPublication(final Date dateOfPublication)
        {
            this.dateOfPublication = dateOfPublication;
        }

    /**
     * get the book's author
     * @return the author's name
     */
    public String getAuthor()
        {
            return author;
        }

    /**
     * set the book's author
     * @param author
     */
    public void setAuthor(String author)
        {
            this.author = author;
        }

    /**
     * get the book's kind
     * @return the book's kind
     */
    public String getKind()
        {
            return kind;
        }

    /**
     * set the book's kind
     * @param kind
     */
    public void setKind(String kind)
        {
            this.kind = kind;
        }

    /**
     * get the book's quantity
     * @return the book's quantity
     */
    public int getQuantity()
        {
            return quantity;
        }

    /**
     * Set the book's quantity
     * @param quantity
     */
    public void setQuantity(int quantity)
        {
            this.quantity = quantity;
        }

    public String getIsbn() {
        return this.ISBN;
    }



    /**
     * Creates a book according to the indicated parameters
     * @param id
     * @param title
     * @param dateOfPublication
     * @param author
     * @param kind
     * @param quantity
     */
    public Book(String id, String title, String isbn,Date dateOfPublication, String author, String kind, int quantity)
        {
            this.id = id;
            this.title = title;
            this.ISBN = isbn;
            this.dateOfPublication = dateOfPublication;
            this.author = author;
            this.kind = kind;
            this.quantity = quantity;
        }

    public Book(String ISBN) {
        this.ISBN = ISBN;
    }
}
