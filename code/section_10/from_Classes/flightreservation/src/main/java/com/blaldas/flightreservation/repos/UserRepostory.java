package com.blaldas.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blaldas.flightreservation.entities.User;

public interface UserRepostory extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}
