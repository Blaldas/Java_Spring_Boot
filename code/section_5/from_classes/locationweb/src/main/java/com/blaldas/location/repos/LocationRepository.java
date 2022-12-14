package com.blaldas.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blaldas.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}