/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurcanlacin.simple.service;

import com.ugurcanlacin.simple.model.Producto;
import com.ugurcanlacin.simple.model.User;
import java.util.List;

/**
 *
 * @author admin
 */
public interface ProductoService {

    void persist(Producto producto);

    Producto findById(int id);

    void update(Producto producto);

    void delete(Producto producto);

    List<Producto> findByCategoria(String categoria);

    List<Producto> findAll();

}
