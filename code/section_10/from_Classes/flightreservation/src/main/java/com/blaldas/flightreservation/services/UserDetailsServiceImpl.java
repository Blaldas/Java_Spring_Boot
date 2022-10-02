package com.blaldas.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blaldas.flightreservation.entities.User;
import com.blaldas.flightreservation.repos.UserRepostory;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepostory userRepostory;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepostory.findByEmail(email); 

		if(user == null)
			throw new UsernameNotFoundException("user with email " + email + " was not found!");
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getRoles());
	}

}
