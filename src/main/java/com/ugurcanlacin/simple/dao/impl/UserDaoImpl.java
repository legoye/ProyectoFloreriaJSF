package com.ugurcanlacin.simple.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ugurcanlacin.simple.dao.UserDao;
import com.ugurcanlacin.simple.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

@Repository("userDao")
public class UserDaoImpl  implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void persistUser(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    public User findUserById(int id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);

    }

    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);

    }

    public User findByUserName(String username) {

        List<User> users = new ArrayList<User>();

        users = sessionFactory.getCurrentSession()
                .createQuery("from user where usuario=?")
                .setParameter(0, username)
                .list();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }

       

    }
}
