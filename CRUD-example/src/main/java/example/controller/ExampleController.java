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
	
	@GetMapping(value = "/get")//test to check that the controller is working
	public String getMessage() {
		return ("test Controller Charly boy");
	}
	
	@GetMapping(value = "/messageToAPI")//this message will be displayed when the end point will be called from other api 
	public String responseOtherAPI() {
		return "Hi from other API";
	}
	
	@GetMapping(value = "/cars")//here we show all car that we have stored in the db
	public List<Car> getCars (){
		return carService.getCars();
	}
	
	@PostMapping(value = "car")//here we save a car into the db
	public Car saveCar(@RequestBody Car car) {
		return carService.saveCar(car);
	}

}
