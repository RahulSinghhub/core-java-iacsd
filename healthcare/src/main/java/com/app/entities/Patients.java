package com.app.entities;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name = "patients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Patients {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private  int pid;
	 private  String first_name;
	 private  String last_name;
	 private  String issue;      
	 private  LocalTime appointment;  
	 private  String email;       
	 private  String passwd;
	 	 
		/*
		 * public Patients(int pid, String first_name, String last_name, String issue,
		 * LocalTime appointment, String email, String passwd) { super(); this.pid =
		 * pid; this.first_name = first_name; this.last_name = last_name; this.issue =
		 * issue; this.appointment = appointment; this.email = email; this.passwd =
		 * passwd; }
		 * 
		 * @Override public String toString() { return "Patients [pid=" + pid +
		 * ", first_name=" + first_name + ", last_name=" + last_name + ", issue=" +
		 * issue + ", appointment=" + appointment + ", email=" + email + ", passwd=" +
		 * passwd + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() +
		 * ", toString()=" + super.toString() + "]"; } public int getPid() { return pid;
		 * } public void setPid(int pid) { this.pid = pid; } public String
		 * getFirst_name() { return first_name; } public void setFirst_name(String
		 * first_name) { this.first_name = first_name; } public String getLast_name() {
		 * return last_name; } public void setLast_name(String last_name) {
		 * this.last_name = last_name; } public String getIssue() { return issue; }
		 * public void setIssue(String issue) { this.issue = issue; } public LocalTime
		 * getAppointment() { return appointment; } public void setAppointment(LocalTime
		 * appointment) { this.appointment = appointment; } public String getEmail() {
		 * return email; } public void setEmail(String email) { this.email = email; }
		 * public String getPasswd() { return passwd; } public void setPasswd(String
		 * passwd) { this.passwd = passwd; }
		 */
	 
	 
	 
	 

}
