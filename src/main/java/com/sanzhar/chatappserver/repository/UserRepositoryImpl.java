package com.sanzhar.chatappserver.repository;

import com.sanzhar.chatappserver.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public User getUserByLoginAndPassword(String login, String password) {
        Session session = sessionFactory.getCurrentSession();

        List<User> users = session.createQuery("from User where login=:login and password=:pass")
                .setParameter("login", login)
                .setParameter("pass", password).list();
        User user = null;

        if(!users.isEmpty()){
            user = users.get(0);
        }

        return user;
    }

    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }
}
