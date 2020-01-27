package example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import example.model.dao.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

}
