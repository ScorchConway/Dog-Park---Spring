package com.example.dp.dogpark.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.dp.dogpark.domain.Park;

public interface ParkRepository extends CrudRepository<Park, Integer> {

}
