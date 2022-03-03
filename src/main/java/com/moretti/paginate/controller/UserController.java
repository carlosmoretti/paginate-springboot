package com.moretti.paginate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moretti.paginate.model.User;
import com.moretti.paginate.service.ServiceBase;
import com.moretti.paginate.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController<User, Long> {
	
	@Autowired
	UserService userService;

	@Override
	public ServiceBase<User, Long> getService() {
		// TODO Auto-generated method stub
		return userService;
	}
}
