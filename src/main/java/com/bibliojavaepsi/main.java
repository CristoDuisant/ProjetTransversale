package com.bibliojavaepsi;

import java.awt.*;
import com.bibliojavaepsi.presentation.Acceuil;

public class main {
    public main() {
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Acceuil();
                } catch (Exception var2) {
                    var2.printStackTrace();
                }

            }
        });
    }
}

