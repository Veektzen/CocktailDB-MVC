package com.model.repository;

import com.model.dao.Cocktail;
import org.json.JSONArray;


import java.util.List;

public interface ICocktailRepository {

    List<Cocktail> getAll();

    JSONArray getCocktailDetails(String id);


}
