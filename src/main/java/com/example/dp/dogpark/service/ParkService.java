package com.example.dp.dogpark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dp.dogpark.domain.Park;
import com.example.dp.dogpark.domain.ParkAddress;
import com.example.dp.dogpark.repository.ParkRepository;

@Service
public class ParkService {

	private ParkRepository parkRepository;
	
	@Autowired
	public ParkService(ParkRepository parkRepository) {
		this.parkRepository = parkRepository;
	}
	
	/**
	 * @param name
	 * @param address
	 * @param website
	 * @param gMapsLink
	 */
	public Park createPark(String name, ParkAddress address, String website, String gMapsLink) {
		return parkRepository.save(new Park(name, address, website, gMapsLink)); 
	}
	
	public Iterable<Park> findAll() {
		return parkRepository.findAll();
	}
	
	/**
	 * 
	 * @param park the park user is checking into
	 * @param numOfDogs number of dogs the user is checking in
	 * @return updated number of dogs checked into park
	 */
	public int checkIn(Park park, int numOfDogs) {
		park.setNumOfDogsCheckedIn(numOfDogs);
		return park.getNumOfDogsCheckedIn();
	}
	
	/**
	 * 
	 * @param park, the park the user is checking out of
	 * @param numOfDogs number of dogs the user is checking out
	 * @return updated number of dogs checked into park
	 */
	public int checkOut(Park park, int numOfDogs) {
		park.setNumOfDogsCheckedIn(numOfDogs * -1);
		return park.getNumOfDogsCheckedIn();
	}
	
}
