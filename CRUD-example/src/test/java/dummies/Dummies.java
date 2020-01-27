package dummies;

import example.model.dao.Car;
import example.model.domain.CarDomain;
import lombok.Data;

@Data
public class Dummies {
	
    public static Car DaoDummy() {
    	Car carDao =  new Car();
    	carDao.setIdCar(1);
    	carDao.setModel("2008");
    	carDao.setName("name");
    	carDao.setVersion("version");
    	return carDao;
    }
    
    public static CarDomain DomainDummy() {
    	CarDomain carDamain =  new CarDomain();
    	carDamain.setIdCar(1);
    	carDamain.setModel("2008");
    	carDamain.setName("name");
    	carDamain.setVersion("version");
    	return carDamain;
    }
}
