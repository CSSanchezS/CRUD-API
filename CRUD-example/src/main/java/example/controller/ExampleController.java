package example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import example.model.dao.Driver;
import example.model.domain.CarDomain;
import example.service.CarService;
import example.service.DriverService;

@CrossOrigin
@RestController
@RequestMapping(value = "API1" )
public class ExampleController {
	
	Logger log = LoggerFactory.getLogger(ExampleController.class);
	
	@Autowired
	CarService carService;
	
	@Autowired
	DriverService driverService;
	
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
		log.info("Controller -> get cars");
		return carService.getCars();
	}
	
	@GetMapping(value = "/car/{id}")
	public CarDomain car(@PathVariable int id) {
		log.info("Controller -> show a car stored in the data base with thw id gived: "+id);
		return carService.getCar(id);
	}
	
	@PostMapping(value = "car")//here we save a car into the db
	public CarDomain saveCar(@RequestBody CarDomain carDomain) {
		log.info("Controller -> save car into the data base :{} ", carDomain);
		return carService.saveCar(carDomain);
	}
	
	@PutMapping(value = "car" )
	public CarDomain updateCar(@RequestBody CarDomain carDomain) {
		log.info("Controller -> update car stored into the data base {}", carDomain);
		return carService.updateCar(carDomain);
	}
	
	@DeleteMapping(value = "car/{id}")
	public void deleteCar(@PathVariable int id) {
		log.info("Controller -> delete car stored into the data base with this id : "+ id);
		carService.deleteCar(id);
	}
	
	@GetMapping(value = "drivers")
	public List<Driver> getDrivers() {
		return driverService.getDrivers();
	}

}
