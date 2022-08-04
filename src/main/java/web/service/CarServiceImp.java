package web.service;

import jdk.jfr.TransitionFrom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.CarDAO;
import web.model.Car;

import java.util.Arrays;
import java.util.List;
@Component
@Transactional
public class CarServiceImp implements CarService{

    private CarDAO connection;
    @Autowired
    public CarServiceImp(CarDAO connection) {
        this.connection = connection;
    }

    @Override
    public void addCar(Car car) {
        connection.addCar(car);
    }

    @Override
    public void removeCarById(int id) {
        connection.removeCarById(id);
    }

    @Override
    public List<Car> getListCars() {
        return connection.getListCars();
    }

    @Override
    public Car getCarById(int id) {
        return connection.getCarById(id);
    }

    @Override
    public void updateCar(int id, Car car) {
        connection.updateCar(id, car);
    }
}
