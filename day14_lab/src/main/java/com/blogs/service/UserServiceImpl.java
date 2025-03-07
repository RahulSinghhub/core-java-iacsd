package com.blogs.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.custom_exceptions.InvalidCredentialAndException;
import com.blogs.dto.AuthDto;
import com.blogs.dto.UserRespDto;
import com.blogs.entities.User;
import com.blogs.repository.UserRepository;

@Service
@Transactional

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserRespDto authenticateUser(AuthDto dto) {
		// TODO Auto-generated method stub
		//it contains the business logic
		//read email and password from authdto and 
		User user = userRepository.findByEmailAndPassword(dto.getEmail(),dto.getPwd())
		.orElseThrow(()->new InvalidCredentialAndException("invalid credential email and pass"));
		return mapper.map(user,UserRespDto.class);

	
	}

}
