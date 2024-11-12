package com.crime.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crime.dao.crimes.IUserRepository;
import com.crime.entity.crimes.StationUser;
import com.crime.exceptions.ApplicationException;
import com.crime.security.CustomUserDetails;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		StationUser user = userRepository.findByUserName(username).orElseThrow(() -> ApplicationException.builder()
				.httpStatus(HttpStatus.NOT_FOUND).message("No user found !! Please register first.").build());
		return new CustomUserDetails(user);
	}

}
