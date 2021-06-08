package com.by.petranovski.sql.myjdbc.dao;

public interface Dao<T, E> {
    // CRUD
    void save(T t); // save new if id != null , otherwise update
    T findAll();
    T findById(E id);
    void delete(T t);
    void deleteById(E id);
}
