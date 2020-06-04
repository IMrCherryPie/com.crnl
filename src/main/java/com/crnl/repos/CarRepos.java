package com.crnl.repos;

import com.crnl.domain.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepos extends CrudRepository<Car, Long> {

    List<Car> findAll();

    Car findByVinBody(String vinBody);

}
