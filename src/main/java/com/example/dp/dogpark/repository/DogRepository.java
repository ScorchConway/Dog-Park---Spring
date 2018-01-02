package com.example.dp.dogpark.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.dp.dogpark.domain.Dog;

public interface DogRepository extends CrudRepository<Dog, Integer> {
	
}
