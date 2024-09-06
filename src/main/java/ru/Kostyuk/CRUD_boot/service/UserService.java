package ru.Kostyuk.CRUD_boot.service;

import ru.Kostyuk.CRUD_boot.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void createUser(User user);
    User readUser(Long id);
    void deleteUser(Long id);
    void updateUser(Long id, User user);
}
