package example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.model.dao.Location;
import example.repository.mongoRepository.MongoRepo;

@Service
public class LocationserviceImpl implements LocationService{

	@Autowired
	MongoRepo mongoRepo;
	
	@Override
	public List<Location> getLocations() {
		Location location =  new Location();
		location.setAddress("kakaka");
		location.setCity("af");
		location.setLocationName("kqnf");
		mongoRepo.save(location);
		
		return mongoRepo.findAll();
	}

}
