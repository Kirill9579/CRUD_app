package web.dao;

import web.model.Car;

import java.util.List;

public interface CarDAO {
    void addCar(Car car);
    void removeCarById(int id);
    List<Car> getListCars();
    Car getCarById(int id);
    void updateCar(int id, Car car);

}
