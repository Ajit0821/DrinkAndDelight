package com.cg.sprint1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.sprint1.entity.UserDetails;

@Repository
public interface ICustomerRegisterDao extends JpaRepository<UserDetails, String> {
	
}
