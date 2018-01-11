package com.example.dp.dogpark.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.dp.dogpark.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByEmail(String email);
}
