package example.validationHelper;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;

import example.model.domain.CarDomain;

@Component
public  class ValidationsHelper{
	
	@SuppressWarnings("serial")
	public void validateLength(CarDomain carDomain) {
		if(carDomain != null) {
			int aux = Integer.parseInt(carDomain.getModel());
			if(aux <= 2010) {
//				throw new HttpServerErrorException(HttpStatus.CONFLICT,
//			              "The model should be greater than 2010");
//				
				throw new HttpStatusCodeException(HttpStatus.CONFLICT,
			              "The model should be greater than 2010") {
				};
			}
			
		}
	}
}
