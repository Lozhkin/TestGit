package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {
    }

    @Override
    public void createUsersTable() {
        String sqlStatement = """
                CREATE TABLE `mydbtest`.`users` (
                  `id` INT NOT NULL AUTO_INCREMENT,
                  `name` VARCHAR(45) NULL,
                  `lastName` VARCHAR(45) NULL,
                  `age` INT(3) UNSIGNED NULL,
                  PRIMARY KEY (`id`),
                  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);""";

        try (Connection connection = Util.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(sqlStatement);
        } catch (SQLException e) {
        }
    }

    @Override
    public void dropUsersTable() {
        String sqlStatement = "DROP TABLE users;";
        try (Connection connection = Util.getConnection(); Statement statement = connection.createStatement()){
            statement.execute(sqlStatement);
        } catch (SQLException e) {
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        String sqlStatement = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";

        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void removeUserById(long id) {
        String sqlStatement = "DELETE FROM users WHERE id = ?";

        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sqlStatement = "SELECT name, lastName, age FROM users";

        try (Connection connection = Util.getConnection(); Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }

        } catch (SQLException e) {
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        String sqlStatement = "DELETE FROM users";

        try (Connection connection = Util.getConnection(); Statement statement = connection.createStatement()){
            statement.execute(sqlStatement);

        } catch (SQLException e) {
        }
    }
}
