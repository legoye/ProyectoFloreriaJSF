/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurcanlacin.simple.dao.impl;

import com.ugurcanlacin.simple.dao.ProductoDao;
import com.ugurcanlacin.simple.dao.UserDao;
import com.ugurcanlacin.simple.model.Producto;
import com.ugurcanlacin.simple.model.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository("productoDao")
public class ProductoDaoImpl  implements ProductoDao {
    
    @Autowired
    private SessionFactory sessionFactory;

    public void persist(Producto producto) {
        sessionFactory.getCurrentSession().persist(producto);
    }

    public Producto findById(int id) {
        return (Producto) sessionFactory.getCurrentSession().get(Producto.class, id);
    }

    public void update(Producto producto) {
        sessionFactory.getCurrentSession().update(producto);

    }

    public void delete(Producto producto) {
        sessionFactory.getCurrentSession().delete(producto);

    }

    public List<Producto> findByCategoria(String categoria) {

        List<Producto> producto = new ArrayList<Producto>();

        producto = sessionFactory.getCurrentSession()
                .createQuery("from user where usuario=?")
                .setParameter(0, categoria)
                .list();

        if (producto.size() > 0) {
            return producto;
        } else {
            return null;
        }

       

    }
    
    
    public List<Producto> findAll() {
        
        List<Producto> lista = null ;  
        Session s = sessionFactory.getCurrentSession();
        
        try{
            
        lista = s.createQuery(" from Producto").list();
        }catch(HibernateException e){
        e.printStackTrace();
            System.out.println("fadfadf");
        }
        return lista;
    }

    
    
    
}
