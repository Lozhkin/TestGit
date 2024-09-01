package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void createUser(User user);
    User readUser(int id);
    void deleteUser(int id);
    void updateUser(int id, User user);
}
