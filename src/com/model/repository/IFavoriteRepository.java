package com.model.repository;

import com.model.dao.Cocktail;

import java.io.IOException;

public interface IFavoriteRepository {

    void add(Cocktail cocktail) throws IOException;
}
