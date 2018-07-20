package com.bibliojavaepsi.presentation;

import com.bibliojavaepsi.model.Book;

import javax.swing.*;
import java.util.Iterator;

public class Acceuil extends JFrame{

    private JPanel contentPane;
    private static Book biblio;

    public Accueil(Boolean prod) {
        if (prod) {
            try {
                biblio = Book.
                biblio.addBook("AZT-RTE");
                biblio.addBook("AZT-RTE");
                Iterator var3 = biblio.getBooks().iterator();

                while(var3.hasNext()) {
                    Book b = (Book)var3.next();
                    System.out.println(b.toString());
                }

                Accueil frame = new Accueil();
                frame.setVisible(true);
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        }

    }
}