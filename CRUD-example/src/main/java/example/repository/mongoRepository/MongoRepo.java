package example.repository.mongoRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import example.model.dao.Location;

@Repository
public interface MongoRepo extends MongoRepository<Location, String>{

}
