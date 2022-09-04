package com.blaldas.location.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blaldas.location.entities.Location;
import com.blaldas.location.repos.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationRepository repo;
	
	@Override
	public Location saveLocation(Location location) {
		return repo.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return repo.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		repo.delete(location);

	}

	@Override
	public Location getLocationById(int id) {
		return repo.getReferenceById(id);
	}

	@Override
	public List<Location> getAllLocation() {
		return repo.findAll();
	}

}
