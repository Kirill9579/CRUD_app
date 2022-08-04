package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Car;
import web.service.CarService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class CarsController {

    private CarService carService;
    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String printCarToCount(ModelMap model, HttpServletRequest request) {
        model.addAttribute("cars", carService.getListCars());
        return "cars";
    }
    @GetMapping("/new")
    public String addCar(ModelMap model) {
        model.addAttribute("car", new Car());
        return "addCar";
    }
    @PostMapping
    public String createCar(@ModelAttribute("car") Car car) {
        carService.addCar(car);
        return "redirect:/";
    }
    @GetMapping("/{id}/update")
    public String editCar(Model model, @PathVariable("id") int id) {
        model.addAttribute("car", carService.getCarById(id));
        return "/updateCar";
    }
    @PatchMapping("/{id}")
    public String updateCar(@ModelAttribute("car") Car car, @PathVariable("id") int id) {
        carService.updateCar(id, car);
        return "redirect:/";
    }
    @GetMapping("/{id}")
    public String showCar(Model model, @PathVariable("id") int id) {
        model.addAttribute("car", carService.getCarById(id));
        return "/oneCar";
    }
    @DeleteMapping("/{id}")
    public String removeCar(@PathVariable("id") int id) {
        carService.removeCarById(id);
        return "redirect:/";
    }

}
