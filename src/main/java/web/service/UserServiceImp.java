package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;
@Service
@Transactional
public class UserServiceImp implements UserService {

    private UserDAO connection;
    @Autowired
    public UserServiceImp(UserDAO connection) {
        this.connection = connection;
    }

    @Override
    public void addUser(User user) {
        connection.addUser(user);
    }

    @Override
    public void removeUserById(int id) {
        connection.removeUserById(id);
    }

    @Override
    public List<User> getListUsers() {
        return connection.getListUsers();
    }

    @Override
    public User getUserById(int id) {
        return connection.getUserById(id);
    }

    @Override
    public void updateUser(int id, User user) {
        connection.updateUser(id, user);
    }
}
