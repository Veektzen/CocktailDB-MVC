package com.model.singleton;

import com.model.repository.*;

/**
 * This is the singleton class
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    private IGenericRepository favoritesR;
    private IGenericRepository cocktailsR;

    private Singleton() {
        favoritesR = new FavoriteRepository();
        cocktailsR = new CocktailRepository();
        cocktailsR.getAll();
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public CocktailRepository getCocktailR() {

        return (CocktailRepository) cocktailsR;
    }

    public FavoriteRepository getFavoriteR() {

        return (FavoriteRepository) favoritesR;
    }
}
