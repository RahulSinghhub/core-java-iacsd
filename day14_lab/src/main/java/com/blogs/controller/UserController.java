package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.ApiResponse;
import com.blogs.dto.AuthDto;
import com.blogs.dto.UserRespDto;
import com.blogs.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	public UserController() {
		System.out.println("in constructor of start");
	}
	/*
	 * authenticate user 
	 * url port
	 * http://localhost:8080/users/signin
	 * method - post only for security later for creating a new resource jwt json web token 
	 * req  - auth dto (email,password) 
	 * success resoponse =   resp data -- fname , last name m,dob , phone no
	 * in case of failure api response filled with error message
*/
	
	@PostMapping("/signin")//unmarshalling because taking data in json from client and then changing it to java
	public ResponseEntity<?> userSignIn(@RequestBody AuthDto dto){
		System.out.println("in sign in for user"+ dto);
		try {
		 UserRespDto respdto = userService.authenticateUser(dto);
		 return ResponseEntity.ok(respdto);//200 is ok and response dto is emitted
		}
		catch(RuntimeException e) {
			System.out.println(e);
			//resp pkt we want 404 if not found we get with err msg
		    return ResponseEntity.status(HttpStatus.NOT_FOUND)
		    .body(new ApiResponse(e.getMessage()));
		}
		
	}
	

}
