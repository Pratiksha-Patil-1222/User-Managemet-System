package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user_table")//table is created
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int userID;
   
   @NotEmpty
   @Size(min = 5,message = "full name contains atleast 5 characters")
   public String fullName;
   
   @Column(name = "email_id",unique = true,length = 30)
   @NotEmpty
   @Email(message = "email is not valid")//prints msg when we give envalid emailid
   public String userEmailID;
   
   @Column(name = "password",length = 20)
   @NotEmpty
   @Size(min = 8,message = "password length must be 8 and contain uppercae,lowercase,digits")
   @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
   public String userPassword;
   
   @Column(name = "phone_number",unique = true)
   @NotEmpty
   @Pattern(regexp = "^[6-9]\\d{9}$",message = "phone number must start between digit 6-9")
   @Size(min = 10,max=10,message = "phone number must contain 10 digits")
   public String phoneNumber;
   
   @NotEmpty
   private String role;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserEmailID() {
		return userEmailID;
	}

	public void setUserEmailID(String userEmailID) {
		this.userEmailID = userEmailID;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
