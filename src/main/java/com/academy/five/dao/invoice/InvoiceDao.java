package com.academy.five.dao.invoice;

import com.academy.five.dao.Dao;

import java.util.List;

public class InvoiceDao implements Dao<Invoice, Integer> {
    @Override
    public void create(Invoice entity) {

    }

    @Override
    public Invoice findById(Integer integer) {
        return null;
    }

    @Override
    public List<Invoice> findAll() {
        return List.of();
    }

    @Override
    public void update(Invoice entity) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
