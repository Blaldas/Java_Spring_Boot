package com.blaldas.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImp implements SecurityService {

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Override
	public boolean login(String username, String password) {
		UserDetails details = userDetailsServiceImpl.loadUserByUsername(username);

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(details, password,
				details.getAuthorities());
		
		authenticationManager.authenticate(token);
		
		boolean state =  token.isAuthenticated();
		
		
		if(state) {
			SecurityContextHolder.getContext().setAuthentication(token);
		}
		
		return state;

	}

}
