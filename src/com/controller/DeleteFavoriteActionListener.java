package com.controller;

import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;

import com.model.dao.CocktailDaoImplementation;
import com.model.singleton.Singleton;
import com.model.dao.Cocktail;
import com.model.dao.CocktailDao;

public class DeleteFavoriteActionListener implements ActionListener {
    Singleton instance = Singleton.getInstance();
    private Cocktail cocktail;
    private List<Cocktail> favorites = instance.getFavoriteR().getAll();
    private JPanel panel;

    public DeleteFavoriteActionListener(Cocktail cocktail,JPanel panel) {
        this.cocktail = cocktail;
        this.panel = panel;
    }

    /**
     * This method is for the action listener of the '-heart' button
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {


        // create dao object
        CocktailDao cocktailDao = new CocktailDaoImplementation(favorites);
        // delete given cocktail from favourite list
        if (favorites.contains(cocktail)) {
            try {
                cocktailDao.deleteFavorite(cocktail);
                panel.setVisible(false);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } else {
            // if the cocktail is already deleted, then display message.
            // Show Warning Dialog
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Item Already Deleted", "Notification",
                    JOptionPane.WARNING_MESSAGE);

        }

    }

}
