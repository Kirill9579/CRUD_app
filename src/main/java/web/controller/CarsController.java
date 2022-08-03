package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImp;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;


@Controller
public class CarsController {
    private CarService carService = new CarServiceImp();


    @GetMapping(value = "/cars")
    public String printCarToCount(ModelMap model, HttpServletRequest request) {
        try {
            int count = Integer.parseInt(request.getParameter("count"));

            model.addAttribute("cars", carService.getLimitListCars(count));
        } catch (Exception e) {
            model.addAttribute("cars", carService.getCars());
        }
        return "cars";
    }

}
