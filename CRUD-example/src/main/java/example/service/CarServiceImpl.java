package example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.controller.ExampleController;
import example.mapper.Transformer;
import example.model.dao.Car;
import example.model.domain.CarDomain;
import example.repository.CarRepository;
import example.validationHelper.ValidationsHelper;

@Service
public class CarServiceImpl implements CarService {
	
	interface MyLambda{
		void heloLambda();
	}
	
	@Autowired
	private ValidationsHelper validatioHelper;

	@Autowired
	CarRepository repo;
	
	@Autowired
	private Transformer transformer;
	
	Logger log = LoggerFactory.getLogger(ExampleController.class);
	
	
	public List<CarDomain> getCars() {
		/*MyLambda myLambdaFuntion = () -> System.out.println("Hello using lambdas");
		myLambdaFuntion.heloLambda();
		//using streamn and lambda
		
		repo.findAll().stream()
			.filter(car -> !car.getName().equals("Sentra"))
			.forEach(car -> System.out.println("Diferente car name from Sentra "+car.getName()));
		//Sum Example 
		int sumId = repo.findAll().stream()
				.mapToInt(car -> car.getIdCar()).sum();
		
		System.err.println("mapToInt using streams "+sumId);*/
		//---------------------
		log.info("Service -> transform the list response from repo and return to the controller"
				+ " {} ",repo.findAll());
		return  transformer.transformToDomainList(repo.findAll());
	}

	public CarDomain getCar(int id) {
		
		Car carDao = repo.getOne(id);
		log.info("Service -> take a car from data base with id gived, id: "+ id);
		return transformer.transformToDomain(carDao);
	}

	public CarDomain saveCar(CarDomain carDomain) {
		validatioHelper.validateLength(carDomain);
		Car carDao = transformer.transformToDao(carDomain);
		
		carDao = repo.save(carDao);
		log.info("Service -> save car into the data base {}",carDao);
		return transformer.transformToDomain(carDao);
	}

	public CarDomain updateCar(CarDomain carDomain) {
		validatioHelper.validateLength(carDomain);
		Car carDao = transformer.transformToDao(carDomain);
		
		carDao = repo.save(carDao);
		log.info("Service -> update car into the data base {}",carDao);
		return transformer.transformToDomain(carDao);
	}

	public void deleteCar(int id) {
		log.info("Service -> delete car with id gived, id:"+ id);
		repo.deleteById(id);
	}

}
