package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    //Методы создания и удаления таблицы пользователей в классе UserHibernateDaoImpl
    //должны быть реализованы с помощью SQL.

    private final SessionFactory sessionFactory = Util.getSessionFactory();

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Session session = sessionFactory.openSession();

        session.close();
        return users;
    }

    @Override
    public void cleanUsersTable() {

    }
}
