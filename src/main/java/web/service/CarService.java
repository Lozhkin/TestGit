package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarService {

    List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car("Ford", "Focus", 2008));
        cars.add(new Car("Honda", "Civic", 2007));
        cars.add(new Car("Audi", "A4", 2008));
        cars.add(new Car("BMW", "G30", 2017));
        cars.add(new Car("Mazda", "CX-5", 2007));
    }

    public List<Car> index() {
        return cars;
    }

}
