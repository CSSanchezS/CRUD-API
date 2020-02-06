package example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import example.exception.ExceptionBussines;
import example.exception.ExceptionNotFound;
import example.model.dao.Driver;
import example.model.dao.Location;
import example.model.domain.CarDomain;
import example.model.domain.ErrorInfo;
import example.service.CarService;
import example.service.DriverService;
import example.service.LocationService;

@CrossOrigin
@RestController
@RequestMapping(value = "API1" )
public class ExampleController {
	
	//add logs to the diferents endpoints
	Logger log = LoggerFactory.getLogger(ExampleController.class);
	
	@Autowired
	CarService carService;
	
	@Autowired
	DriverService driverService;
	
	@Autowired
	LocationService locationService;
	
	@ControllerAdvice
	public class ExceptionController {
	   @ExceptionHandler(ExceptionBussines.class)
	   @ResponseBody
	   public ErrorInfo exception(HttpServletRequest req, ExceptionBussines exception) {
	      return new ErrorInfo(HttpStatus.CONFLICT, req, exception);
	   }
	   
	   @ExceptionHandler(ExceptionNotFound.class)
	   @ResponseBody
	   public ErrorInfo exceptionNotFound(HttpServletRequest req, ExceptionNotFound exception) {
	      return new ErrorInfo(HttpStatus.NOT_FOUND, req, exception);
	   }
	}
	
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
		List<CarDomain> carDomain = new ArrayList<CarDomain>();
		carDomain = carService.getCars();
		return carDomain;
	}
	
	@GetMapping(value = "/car/{id}")
	public CarDomain car(@PathVariable int id)   {
		log.info("Controller -> show a car stored in the data base with thw id gived: "+id);
		CarDomain carDomain = new CarDomain();
		carDomain = carService.getCar(id);
		return carDomain;
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
	
	@GetMapping(value = "driver/{id}")
	public Driver getDriver(@PathVariable int id) {
		return driverService.getDriver(id);
	}
	
	@PostMapping(value = "driver")
	public Driver saveDriver(@RequestBody Driver driver) {
		return driverService.saveDriver(driver);
	}
	
	@GetMapping(value = "/mongoDB")
	public List<Location> getLocation() {
		List<Location> locations = new  ArrayList<Location>();
		locations = locationService.getLocations();
		return locations;
	}

}
