package web.service;

import web.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUser() {
        return null;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Igor", 39));
        users.add(new User("Ilya", 24));
        users.add(new User("Dmitry", 39));
        users.add(new User("Julia", 40));
        users.add(new User("Yaroslav", 13));
        return users;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }
}
