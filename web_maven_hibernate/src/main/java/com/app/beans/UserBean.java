package com.app.beans;

import java.sql.SQLException;

import com.app.dao.UserDaoImpl;
import com.app.entities.User;

public class UserBean {
//state -- request params from clnt mapped to Java bean properties
	private String email;
	private String password;
	//dependency -- dao layer
	private UserDaoImpl userDao;
	//add a property to store validated user details
	private User userDetails;
	private String message;
	private String dob;//since non primitive propertoies cannot be translated only primitive properties can be translated
	private String ln;
	private String fn;
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	//def ctor 
	public UserBean() throws SQLException{
		// create dao instance
		userDao=new UserDaoImpl();
		System.out.println("user bean created...");
	}
	//getter n setter
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserDaoImpl getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}
	public User getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}
	
	public String getMessage() {
		return message;
	}
	//Add B.L method for user authentication
	public String validateUser() {
		System.out.println("in validate user "+email+" "+password);
		//bean --> invokes dao's method
		
		
			//invalid login
			
			try {
			userDetails=userDao.signIn(email, password);
			message="valid login!";
			if(userDetails == null) {
			return "login";//ben returns the routing outcome to jsp 
			}
			catch(RuntimeException e) {
				
			}
		}
		//=> valid login --> chk role based authorization
		message="Login Successful!";
		if(userDetails.getRole().equals("admin"))
			return "admin_main";
		//=> voter login
		if(userDetails.isStatus())
			return "logout";
		//not yet voted
		return "candidate_list";
	}
	
	public String validateAndRegister() {
		
		
		///parse and validate
		//in case of invalid age give error message
		//invoke daos method 
		LocalDate dd = LocalDate.parse(dob);
		int ageInYears  = Period.between(dd,LocalDate.now()).getYears();
		if(ageInYears < 17)
			return 'registration failed';
		/*String s1=userDao.voterRegistration(userDetails);*/
		return userDao.getUserDetails(null, null)
		
		
		
		return "";
		
	}
	
	
	
}
