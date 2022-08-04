package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    void removeUserById(int id);
    List<User> getListUsers();
    User getUserById(int id);
    void updateUser(int id, User user);

}
