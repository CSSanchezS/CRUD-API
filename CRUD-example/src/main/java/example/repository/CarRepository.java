package example.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import example.model.dao.Car;

@org.springframework.stereotype.Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

}
