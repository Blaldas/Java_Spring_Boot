package com.blaldas.location.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blaldas.location.entities.Location;
import com.blaldas.location.repos.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRestController {

	@Autowired
	LocationRepository locationRepository;

	@GetMapping
	public List<Location> getLocations() {
		return locationRepository.findAll();
	}

	@PostMapping
	public Location createLocations(@RequestBody Location location) {
		return locationRepository.save(location);
	}

	@PutMapping
	public Location updateLocations(@RequestBody Location location) {
		return locationRepository.save(location);
	}

	@DeleteMapping("/{id}")
	public void deleLocation(@PathVariable("id") int id) {
		locationRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Location> getOneLocation(@PathVariable("id") int id) {
		return locationRepository.findById(id);
	}
}
