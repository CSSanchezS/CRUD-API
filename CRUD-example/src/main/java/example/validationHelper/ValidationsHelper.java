package example.validationHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import example.exception.ExceptionCatch;
import example.model.domain.CarDomain;
import example.repository.CarRepository;

@Component
public  class ValidationsHelper{
	
	@Autowired
	CarRepository repo;
	
	Logger log = LoggerFactory.getLogger(ValidationsHelper.class);
	
	public void validations(CarDomain carDomain) {
		validationModelYear(carDomain);
		validationLenghtString(carDomain);
			
	}
	public void validationModelYear(CarDomain carDomain) {
		log.info("Model validation is that should be greater than 2010 to save or update car");
		int aux = Integer.parseInt(carDomain.getModel());
		if(aux <= 2010)throw new ExceptionCatch("Model should be greater than 2010");
	}
	
	public void validId(int id, String operation) {
		log.info("Validation Id to "+ operation +" Car");
		if(!repo.existsById(id)) throw new ExceptionCatch("Id is not valid");
	}
	
	public void validationLenghtString(CarDomain carDomain) {
		validationLenghtString("Name",carDomain.getName(),10);
		validationLenghtString("Model",carDomain.getModel(),4);
		validationLenghtString("Version",carDomain.getVersion(),10);
	}
	
	public void validationLenghtString(String name, String string,int maxLength) {
		log.info("Length validation to save and update");
		if(string.length() > maxLength)throw new ExceptionCatch(name +" should not have more than " + maxLength + " characters");
	}
	
	
	
}
