package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();
    void createUser(User user);
    User readUser(Long id);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
}
