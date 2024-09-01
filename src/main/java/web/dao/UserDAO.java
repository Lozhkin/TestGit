package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();
    void createUser(User user);
    User readUser(int id);
    void updateUser(int id, User user);
    void deleteUser(int id);
}
