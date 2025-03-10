package com.blogs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.custom_exceptions.InvalidCredentialsException;
import com.blogs.entities.User;
import com.blogs.repository.UserRepository;

@Service //mandatory class level annotation to tell sc
//following is spring bean containing 
@Transactional//fo adding auto tx management support
public class UserServiceImpl implements UserService{
    //dependency
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public User signInUser(String email, String pwd) {
		// TODO Auto-generated method stub
		Optional<User> optional=userRepository.findByEmailAndPassword(email, pwd);
		return optional.orElseThrow(()-> new InvalidCredentialsException("invalid email and password"));
	}

}
