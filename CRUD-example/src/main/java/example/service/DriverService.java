package example.service;

import java.util.List;

import example.model.dao.Driver;

public interface DriverService {
	
	public List<Driver> getDrivers();
	public Driver getDriver(int id);
	public Driver saveDriver(Driver driver);

}
