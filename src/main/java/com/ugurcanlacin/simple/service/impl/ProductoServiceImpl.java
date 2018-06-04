/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurcanlacin.simple.service.impl;

import com.ugurcanlacin.simple.dao.ProductoDao;
import com.ugurcanlacin.simple.dao.ProductoDao;
import com.ugurcanlacin.simple.model.Producto;
import com.ugurcanlacin.simple.model.Producto;
import com.ugurcanlacin.simple.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Service("productoService")
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoDao productoDao;

    @Transactional
    public void persist(Producto producto) {
        productoDao.persist(producto);

    }

    @Transactional
    public Producto findById(int id) {

        return productoDao.findById(id);
    }

    @Transactional
    public void update(Producto producto) {
        productoDao.update(producto);

    }

    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);

    }

    @Transactional
    @Override
    public List<Producto> findByCategoria(String categoria) {
        return productoDao.findByCategoria(categoria);
    }

    @Transactional
    @Override
    public List<Producto> findAll() {
        return productoDao.findAll();
    }

}
