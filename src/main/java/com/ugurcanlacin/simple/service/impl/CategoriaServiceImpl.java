/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurcanlacin.simple.service.impl;

import com.ugurcanlacin.simple.dao.CategoriaDao;
import com.ugurcanlacin.simple.model.Categoria;
import com.ugurcanlacin.simple.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */

@Service("categoriaService")
public class CategoriaServiceImpl  implements CategoriaService{
    
    @Autowired
    CategoriaDao categoriaDao;
    
    @Transactional
    public Categoria findUserById(int id) {
        return categoriaDao.findUserById(id);
    }

    @Transactional
    @Override
    public List<Categoria> findAll() {
        return categoriaDao.findAll();
    }
    
}
