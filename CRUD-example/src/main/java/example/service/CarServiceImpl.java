package example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.mapper.Transformer;
import example.model.dao.Car;
import example.model.domain.CarDomain;
import example.repository.Repository;
import example.validationHelper.ValidationsHelper;

@Service
public class CarServiceImpl implements CarService {
	
	interface MyLambda{
		void heloLambda();
	}
	
	@Autowired
	private ValidationsHelper validatioHelper;

	@Autowired
	Repository repo;
	
	@Autowired
	private Transformer transformer;
	
	
	public List<CarDomain> getCars() {
		MyLambda myLambdaFuntion = () -> System.out.println("Hello using lambdas");
		myLambdaFuntion.heloLambda();
		//using streamn and lambda
		
		repo.findAll().stream()
			.filter(car -> !car.getName().equals("Sentra"))
			.forEach(car -> System.out.println("Diferente car name from Sentra "+car.getName()));
		//Sum Example 
		int sumId = repo.findAll().stream()
				.mapToInt(car -> car.getIdCar()).sum();
		
		System.err.println("mapToInt using streams "+sumId);
		//---------------------
		return  transformer.transformToDomainList(repo.findAll());
	}

	public CarDomain getCar(int id) {
		
		return transformer.transformToDomain(repo.getOne(id));
	}

	public CarDomain saveCar(CarDomain carDomain) {
		validatioHelper.validateLength(carDomain);
		Car carDao = transformer.transformToDao(carDomain);
		
		carDao = repo.save(carDao);

		return transformer.transformToDomain(carDao);
	}

	public CarDomain updateCar(Car car) {
		return transformer.transformToDomain(repo.save(car));
	}

	public void deleteCar(int id) {
		repo.deleteById(id);
	}

}
