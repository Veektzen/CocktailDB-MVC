package com.controller;

import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.model.dao.CocktailDaoImplementation;
import com.model.singleton.Singleton;
import com.model.dao.Cocktail;
import com.model.dao.CocktailDao;

public class AddFavoriteActionListener implements ActionListener {

    Singleton instance = Singleton.getInstance();
    private Cocktail cocktail;
    private List<Cocktail> favorites = instance.getFavoriteR().getAll();

    public AddFavoriteActionListener(Cocktail cocktail) {
        this.cocktail = cocktail;

    }

    /**
     * This method is for the action listener of the '+heart' button
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // create dao object
        CocktailDao cocktailDao = new CocktailDaoImplementation(favorites);

        // if the cocktail exists in favourite list, then display message.
        if (favorites.contains(cocktail)) {
            // Show Warning Dialog
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Item Already Exists in Favourites", "Notification",
                    JOptionPane.WARNING_MESSAGE);

        } else {
            try {
                // add given cocktail to favourite list
                cocktailDao.addFavorite(cocktail);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}
