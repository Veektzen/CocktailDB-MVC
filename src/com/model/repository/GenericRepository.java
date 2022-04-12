package com.model.repository;

import java.io.IOException;
import java.util.List;

/**
 * this is a generic repository
 *
 * @param <T>
 */
public abstract class GenericRepository<T> implements IGenericRepository<T> {


    private List<T> entities;


    public GenericRepository(List<T> entities) {

        this.entities = entities;
    }


    @Override
    public void add(T entity) throws IOException {
        entities.add(entity);
    }

    @Override
    public T get(String id) {
        return entities.get(Integer.parseInt(id));
    }


    @Override
    public void delete(String id) {
        T entity = get(id);
        entities.remove(entity);
    }

    @Override
    public List<T> getAll() {
        return entities;
    }

    @Override
    public void update(T entity1, T entity2) {

        entities.remove(entity1);
        entities.add(entity2);
    }

}
