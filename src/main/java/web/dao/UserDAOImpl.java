package web.dao;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
        System.out.println(".......................User save.....................");

    }

    @Override
    public void removeUserById(int id) {
        entityManager.remove(getUserById(id));

        System.out.println(".......................User delete.....................");
    }

    @Override
    public List<User> getListUsers() {
        System.out.println(".......................User list show.....................");
        return entityManager
                .createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    public User getUserById(int id) {
        User user = entityManager.find(User.class, id);
        System.out.println(".......................User find.....................");
        return user;
    }

    @Override
    public void updateUser(int id, User user) {
        entityManager.createQuery("update User e set e.name =: name," +
                        " e.lastName =: lastName, e.age =: age where e.id =: id")
                .setParameter("name", user.getName())
                .setParameter("lastName", user.getLastName())
                .setParameter("age", user.getAge())
                .setParameter("id", id).executeUpdate();
        System.out.println(".......................User update.....................");
    }


}
