package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();
    void createUser(User user);
    User readUser(Long id);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
}
