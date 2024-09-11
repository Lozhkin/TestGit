package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void createUser(User user);
    User readUser(Long id);
    void deleteUser(Long id);
    void updateUser(Long id, User user);
}
