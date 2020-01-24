package example.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import example.model.dao.Car;
import example.model.domain.CarDomain;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class Transformer extends ConfigurableMapper{
	@Autowired
	private MapperFacade mapper;
	
	public MapperFactory settingMapper(MapperFactory factory) {
		mapper=factory.getMapperFacade();
	    factory.classMap(Car.class, CarDomain.class).byDefault().register();
	    factory.classMap(CarDomain.class, Car.class).byDefault().register();
		return factory;
	}
	
	public Car transformToDao(CarDomain carDomain) {
		return mapper.map(carDomain, Car.class);
	}
	
	public CarDomain transformToDomain(Car car) {
		return mapper.map(car, CarDomain.class);
	}
	
	public List<CarDomain> transformToDomainList(List<Car> car){
		return mapper.mapAsList(car, CarDomain.class);
	}
}
