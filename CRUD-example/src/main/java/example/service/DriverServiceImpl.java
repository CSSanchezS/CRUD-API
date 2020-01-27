package example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.model.dao.Driver;
import example.repository.DriverRepository;

@Service
public class DriverServiceImpl  implements DriverService{
	
	@Autowired
	DriverRepository driveRepo;

	public List<Driver> getDrivers() {
		return driveRepo.findAll();
	}
	

}
