package web.service;

import jdk.jfr.TransitionFrom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.Arrays;
import java.util.List;

public class CarServiceImp implements CarService{

    private List<Car> cars = Arrays.asList(
            new Car("Tesla", 2020, 432652648),
            new Car("Land Rover", 2021, 753285742),
            new Car("Toyota", 2019, 426426645),
            new Car("Lexus", 1995, 832578234),
            new Car("Honda", 2001, 436543324)
    );

    @Override

    public List<Car> getLimitListCars(int count) {
        return cars.stream().limit(count).toList();
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }
}
