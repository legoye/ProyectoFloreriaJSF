/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurcanlacin.simple.dao.impl;

import com.ugurcanlacin.simple.dao.CategoriaDao;
import com.ugurcanlacin.simple.model.Categoria;
import com.ugurcanlacin.simple.model.Producto;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository("categoriaDao")
public class CategoriaDaoImpl implements CategoriaDao{

    @Autowired
    private SessionFactory sessionFactory;



    public List<Categoria> findAll() {

        List<Categoria> lista = null;
        Session s = sessionFactory.getCurrentSession();

        try {

            lista = s.createQuery(" from Categoria").list();
        } catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("fadfadf");
        }
        return lista;
    }

    public Categoria findUserById(int id) {
        return (Categoria) sessionFactory.getCurrentSession().get(Categoria.class, id);
    }

}
