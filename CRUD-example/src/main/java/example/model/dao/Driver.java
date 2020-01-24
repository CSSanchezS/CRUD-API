package example.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Driver")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDriver;
	private String name;
	private int edad;
	
//	@OneToOne // add a colum from the clase that we specify down
//	private Car car;
	
	@OneToMany
	private List<Car> car =  new ArrayList<Car>();
	
	
}
