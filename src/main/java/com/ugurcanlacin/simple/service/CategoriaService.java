/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurcanlacin.simple.service;

import com.ugurcanlacin.simple.model.Categoria;
import java.util.List;

/**
 *
 * @author admin
 */
public interface CategoriaService {
    
     Categoria findUserById(int id);
     
     List<Categoria> findAll();
    
}
