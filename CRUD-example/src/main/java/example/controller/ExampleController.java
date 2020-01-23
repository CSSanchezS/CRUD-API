package example.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.model.dao.Car;
import example.model.domain.CarDomain;
import example.service.CarService;

@CrossOrigin
@RestController
@RequestMapping(value = "API1" )
public class ExampleController {
	
	private final static Logger Log = Logger.getLogger(ExampleController.class.getName());
	
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
	public List<CarDomain> getCars (){
		Log.info("show all cars tha we have stored in the data base");
		return carService.getCars();
	}
	
	@GetMapping(value = "/car/{id}")
	public CarDomain car(@PathVariable int id) {
		Log.info("show a car stored in the data base with thw id gived "+id);
		return carService.getCar(id);
	}
	
	@PostMapping(value = "car")//here we save a car into the db
	public CarDomain saveCar(@RequestBody CarDomain carDomain) {
		return carService.saveCar(carDomain);
	}
	
	@PutMapping(value = "car" )
	public CarDomain updateCar(@RequestBody Car car) {
		return carService.updateCar(car);
	}
	
	@DeleteMapping(value = "car/{id}")
	public void deleteCar(@PathVariable int id) {
		carService.deleteCar(id);
	}

}
