package web.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Component
public class CarDAOImpl implements CarDAO{
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addCar(Car car) {
        entityManager.persist(car);
        System.out.println(".......................Car save.....................");

    }

    @Override
    public void removeCarById(int id) {
        entityManager.createQuery("delete Car where id =: id")
                        .setParameter("id", id).executeUpdate();

        System.out.println(".......................Car delete.....................");
    }

    @Override
    public List<Car> getListCars() {
        System.out.println(".......................Car list show.....................");
        return entityManager
                .createQuery("select с from Car с", Car.class)
                .getResultList();
    }

    @Override
    public Car getCarById(int id) {
        Car car = entityManager.createQuery("from Car c where c.id =: id", Car.class)
                .setParameter("id", id)
                .getSingleResult();
        System.out.println(".......................Car find.....................");
        return car;
    }

    @Override
    public void updateCar(int id, Car car) {
        entityManager.createQuery("update Car e set e.model =: model, e.modelYear =: modelYear, e.vinCode =: vinCode where e.id =: id")
                .setParameter("model", car.getModel())
                .setParameter("modelYear", car.getModelYear())
                .setParameter("vinCode", car.getVinCode())
                .setParameter("id", id).executeUpdate();
        System.out.println(".......................Car update.....................");
    }


}
