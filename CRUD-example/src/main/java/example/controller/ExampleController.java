package example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.model.dao.Car;
import example.service.CarService;
import example.service.CarServiceImpl;


@RestController
@RequestMapping(value = "API1" )
public class ExampleController {
	
	@Autowired
	CarService carService;
	
	@GetMapping(value = "/get")
	public String getMessage() {
		return ("test Controller Charly boy");
	}
	
	@GetMapping(value = "/messageToAPI")
	public String responseOtherAPI() {
		return "Hi from other API";
	}
	
	@GetMapping(value = "/cars")
	public List<Car> getCars (){
		return carService.getCars();
	}
	
	@PostMapping(value = "car")
	public Car saveCar(@RequestBody Car car) {
		return carService.saveCar(car);
	}

}
