package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarsController {

    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String index(@RequestParam(value = "count", required = false) Integer count, Model model) {
        List<Car> cars = carService.index();
        if (count != null && count <= cars.size()) {
            cars = cars.subList(0, count);
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}
