package example.service;

import java.util.List;

import example.model.domain.CarDomain;

public interface CarService {
	
	public List<CarDomain> getCars();
	public CarDomain getCar(int id);
	public CarDomain saveCar(CarDomain car);
	public CarDomain updateCar(CarDomain car);
	public void deleteCar(int id);
	

}
