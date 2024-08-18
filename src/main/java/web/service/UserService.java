package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    User getUser();
    List<User> getUsers();
    void saveUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
}
