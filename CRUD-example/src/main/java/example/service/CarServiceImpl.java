package example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.model.dao.Car;
import example.repository.Repository;

@Service
public class CarServiceImpl implements CarService{
	
	@Autowired
	Repository repo;
	
	public List<Car> getCars(){
		
		return repo.findAll();
	}
	
	public Car saveCar(Car car) {
		
		return repo.save(car);
	}

}
