package testController;

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
import example.controller.ExampleController;
import example.model.domain.CarDomain;
import example.service.CarServiceImpl;

@RunWith(SpringRunner.class)
public class testController extends AbstractJUnit4SpringContextTests {

	@Mock
	CarServiceImpl carService;

	@InjectMocks
	ExampleController controller;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllCarsTest() {
		when(carService.getCars()).thenReturn(new ArrayList<CarDomain>());
		List<CarDomain> list = controller.getCars();
		Assert.assertEquals(list.isEmpty(), true);
	}

	@Test
	public void createCar() {
		when(carService.saveCar(Dummies.DomainDummy())).thenReturn(Dummies.DomainDummy());
		CarDomain carDomain = controller.saveCar(Dummies.DomainDummy());
		Assert.assertNotNull(carDomain);
	}

	@Test
	public void updateClient() {
		when(carService.saveCar(Dummies.DomainDummy())).thenReturn(Dummies.DomainDummy());
		CarDomain carDomain = controller.saveCar(Dummies.DomainDummy());
		Assert.assertNotNull(carDomain);
	}

	@Test
	public void deleteClient() {
		doNothing().when(carService).deleteCar(1);
		controller.deleteCar(1);
	}

}
