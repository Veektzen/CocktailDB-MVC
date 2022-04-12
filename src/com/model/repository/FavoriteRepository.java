package com.model.repository;

import com.model.dao.Cocktail;
import com.model.dao.CocktailDaoImplementation;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FavoriteRepository extends GenericRepository<Cocktail> implements IFavoriteRepository {

    //initiate favorites list
    public static List<Cocktail> favorites = new ArrayList<Cocktail>();

    /**
     * this method reads favorites from json and inserts it in favorites list
     *
     * @return favorites list
     * @throws JSONException
     * @throws FileNotFoundException
     */
    public List<Cocktail> readJson() throws JSONException, FileNotFoundException {

        JSONArray favoritesArray = new JSONArray(new JSONTokener(new FileReader("src\\fav.json")));
        for (int i = 0; i < favoritesArray.length(); i++) {
            favorites.add(new Cocktail());
            favorites.get(i).setId((favoritesArray.getJSONObject(i).getString("id")));
            favorites.get(i).setName((favoritesArray.getJSONObject(i).getString("name")));
            favorites.get(i).setImg((favoritesArray.getJSONObject(i).getString("img")));
            if(favoritesArray.getJSONObject(i)!=null)
            favorites.get(i).setCategory((favoritesArray.getJSONObject(i).getString("category")));

        }
        return favorites;
    }

    private CocktailDaoImplementation dao;

    public FavoriteRepository() {
        super(favorites);
        dao = new CocktailDaoImplementation(favorites);
    }

    /**
     * this method adds a cocktail to favorites list
     *
     * @param cocktail
     * @throws IOException
     */
    @Override
    public void add(Cocktail cocktail) throws IOException {

        dao.addFavorite(cocktail);
    }
}
