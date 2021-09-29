package com.cg.sprint1.service;

import com.cg.sprint1.dto.UserDetailsDto;
import com.cg.sprint1.entity.UserDetails;

public interface ICustomerRegister {

	UserDetails register(UserDetails uDetails);

	UserDetails findByName(UserDetailsDto userDetails);

	UserDetails findByName(String uName);

	UserDetails register1(UserDetails udetails);


}
