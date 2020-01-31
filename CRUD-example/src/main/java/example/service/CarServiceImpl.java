package example.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.controller.ExampleController;
import example.exception.ExceptionCatch;
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
		List<CarDomain> carDomain = new ArrayList<CarDomain>();
		carDomain = transformer.transformToDomainList(repo.findAll());
		log.info("Service -> transform the list response from repo and return to the controller"
				+ " {} ",carDomain);
		return  carDomain;
	}

	public CarDomain getCar(int id)  {
		//if(!repo.existsById(id)) throw new BadRequestException("id is not valid");
		validatioHelper.validId(id,"get");
		Car carDao = repo.getOne(id);
		log.info("Service -> take a car from data base with id gived, id: "+ id);
		return transformer.transformToDomain(carDao);
	}

	public CarDomain saveCar(CarDomain carDomain) {
		validatioHelper.validations(carDomain);
		Car carDao = transformer.transformToDao(carDomain);
		carDao = repo.save(carDao);
		log.info("Service -> save car into the data base {}",carDao);
		return transformer.transformToDomain(carDao);
	}

	public CarDomain updateCar(CarDomain carDomain) {
		validatioHelper.validations(carDomain);
		Car carDao = transformer.transformToDao(carDomain);
		carDao = repo.save(carDao);
		log.info("Service -> update car into the data base {}",carDao);
		return transformer.transformToDomain(carDao);
	}

	public void deleteCar(int id) {
		validatioHelper.validId(id,"delete");
		log.info("Service -> delete car with id gived, id:"+ id);
		try {
			repo.deleteById(id);
		}catch (Exception e) {
			// TODO: handle exception
			throw new ExceptionCatch("Car cannot be deleted, it has a relationship with a Driver");
		}
		
	}

}
