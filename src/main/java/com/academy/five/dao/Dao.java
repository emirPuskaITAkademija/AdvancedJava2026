package com.academy.five.dao;

import java.util.List;

/**
 * CRUD
 * Create
 * Retrieve/Read
 * Update
 * Delete
 * <p>
 * Entitet : Person klasa, person tabela
 * Invoice klasa, invoice tabela
 * <p>
 * Person ima properties: id, name, surname, birthday...
 * person ima kolone: id, name, surname...
 * <p>
 * red versus objekat
 *
 */
public interface Dao<E, ID> {

    String URL = "jdbc:mysql://localhost:3306/human";
    String USERNAME = "root";
    String PASSWORD = "root";

    void create(E entity);

    E findById(ID id);

    List<E> findAll();

    void update(E entity);

    void deleteById(ID id);
}
