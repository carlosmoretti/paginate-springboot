package com.moretti.paginate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.moretti.paginate.model.User;
import com.moretti.paginate.repository.UserRepository;
import com.moretti.paginate.service.UserService;

@Service
public class UserServiceImpl extends ServiceBaseImpl<User, Long> implements UserService {
	
	@Autowired
	UserRepository repository;

	@Override
	public JpaRepository<User, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

}
