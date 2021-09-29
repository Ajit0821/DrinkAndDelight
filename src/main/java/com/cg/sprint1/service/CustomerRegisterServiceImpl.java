package com.cg.sprint1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.sprint1.dao.ICustomerRegisterDao;
import com.cg.sprint1.exception.PasswordAuthenticationFailedException;
//import com.cg.sprint1.exception.PasswordAuthenticationFailedException;
import com.cg.sprint1.exception.UserNameAlreadyExistsException;
import com.cg.sprint1.exception.UserRegistrationException;
import com.cg.sprint1.exception.UserRegistrationException;
import com.cg.sprint1.dto.UserDetailsDto;
import com.cg.sprint1.entity.UserDetails;
import com.cg.sprint1.exception.UserNameAlreadyExistsException;

@Service
@Transactional
public class CustomerRegisterServiceImpl implements ICustomerRegister {

	@Autowired
	private ICustomerRegisterDao dao;
	
	@Override
	public UserDetails register(UserDetails uDetails) {
		List<UserDetails> uDetailsList = dao.findAll();
		for (UserDetails user : uDetailsList) {
			if(user.getUsername().equals(uDetails.getUsername())) {
				throw new UserNameAlreadyExistsException("Username : " + uDetails.getUsername() + " alreday exists");
			}
		}
		UserDetails details = dao.save(uDetails); 
		return details;
	}

	@Override
	public UserDetails findByName(UserDetailsDto details) {
		Optional<UserDetails> detailsOpt = dao.findById(details.getUsername());
		if(!detailsOpt.isPresent()) {
			throw new UserRegistrationException("User with username : " + details.getUsername() + " not registered");
		}
		UserDetails uDetails = detailsOpt.get();
		if(!details.getPassword().equals(uDetails.getPassword())) {
			throw new PasswordAuthenticationFailedException("Invalid credentials");
		}
		return uDetails;
	}

	@Override
	public UserDetails findByName(String uName) {
		Optional<UserDetails> opt = dao.findById(uName);
		return opt.get();
	}

	@Override
	public UserDetails register1(UserDetails uDetails) {
		UserDetails details = dao.save(uDetails); 
		return details;
	}

}
