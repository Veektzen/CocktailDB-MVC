package com.controller;

import com.model.dao.Cocktail;
import com.model.dao.CocktailDao;
import com.model.dao.CocktailDaoImplementation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import com.model.singleton.Singleton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class SetEnumActionListener implements ActionListener {
    JComboBox comboBox;
    Cocktail favorite;
    Singleton instance = Singleton.getInstance();
    private List<Cocktail> favorites = instance.getFavoriteR().getAll();

    public SetEnumActionListener(Cocktail favorite, JComboBox<String> comboBox) {
        this.favorite=favorite;
        this.comboBox=comboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CocktailDao cocktailDao = new CocktailDaoImplementation(favorites);
        try {
            cocktailDao.addCategory(favorite,comboBox.getSelectedItem().toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
