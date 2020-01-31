package testService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import dummies.Dummies;
import example.mapper.Transformer;
import example.model.dao.Car;
import example.model.domain.CarDomain;
import example.repository.CarRepository;
import example.service.CarServiceImpl;
import example.validationHelper.ValidationsHelper;

@RunWith(SpringRunner.class)
public class testService extends AbstractJUnit4SpringContextTests {

	@InjectMocks
	CarServiceImpl carSer;

	@Mock
	CarRepository repo;

	@Mock
	Transformer transformer;

	@Mock
	ValidationsHelper validationHelper;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllCarsTest() {
		when(repo.findAll()).thenReturn(new ArrayList<Car>());
		List<CarDomain> allCars = carSer.getCars();
		Assert.assertEquals(allCars.isEmpty(), true);
	}

	@Test
	public void getCarById() {
		when(repo.getOne(1)).thenReturn(Dummies.DaoDummy());
		when(transformer.transformToDomain(Dummies.DaoDummy())).thenReturn(Dummies.DomainDummy());
		CarDomain carDomain = carSer.getCar(1);
		Assert.assertNotNull(carDomain);
		assertEquals("name", carDomain.getName());
	}

	@Test
	public void createCar() {
		when(transformer.transformToDao(Dummies.DomainDummy())).thenReturn(Dummies.DaoDummy());
		when(repo.save(Dummies.DaoDummy())).thenReturn(Dummies.DaoDummy());
		when(transformer.transformToDomain(Dummies.DaoDummy())).thenReturn(Dummies.DomainDummy());
		CarDomain carDomain = carSer.saveCar(Dummies.DomainDummy());
		doNothing().when(validationHelper).validations(Dummies.DomainDummy());
		Assert.assertNotNull(carDomain);

	}

	@Test
	public void updateCar() {
		when(transformer.transformToDao(Dummies.DomainDummy())).thenReturn(Dummies.DaoDummy());
		when(repo.save(Dummies.DaoDummy())).thenReturn(Dummies.DaoDummy());
		when(transformer.transformToDomain(Dummies.DaoDummy())).thenReturn(Dummies.DomainDummy());
		CarDomain carDomain = carSer.updateCar(Dummies.DomainDummy());
		doNothing().when(validationHelper).validations(Dummies.DomainDummy());
		Assert.assertNotNull(carDomain);

	}

	@Test
	public void deleteClient() {
		doNothing().when(repo).deleteById(1);
		carSer.deleteCar(1);
	}

	@Test
	public void getCarsEmpty() {
		when(repo.findAll()).thenReturn(new ArrayList<>());
		List<CarDomain> list = carSer.getCars();
		Assert.assertEquals(list.isEmpty(), true);
	}

}
