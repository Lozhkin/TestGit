package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.dao.UserDAO;
import web.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    public User readUser(Long id) {
        return userDAO.readUser(id);
    }

    @Override
    public void updateUser(Long id, User user) {
        userDAO.updateUser(id, user);
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }
}
