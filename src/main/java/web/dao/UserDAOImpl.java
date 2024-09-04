package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User readUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void updateUser(Long id, User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
