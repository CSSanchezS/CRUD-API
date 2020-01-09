package example.service;

import java.util.List;

import example.model.dao.Car;

public interface CarService {
	
	public List<Car> getCars();
	public Car saveCar(Car car);

}
