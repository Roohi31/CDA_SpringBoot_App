package org.jsp.cda.entity;

import org.jsp.cda.util.UserRole;
import org.jsp.cda.util.UserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	// to make our email true and non nullable
	@Column(unique = true , nullable = false)
	private String username;
	
//	// to make our pwd true and non nullable
//	@Column(nullable = false)
	private String password;
	
//	@Column(nullable = false)
	private String name;
	
//	@Column(unique = true , nullable = false)
	private String email;
	
//	@Column(unique = true , nullable = false)
	private long phone;
	
	// if we dont use this annotation we will get numbers instead of String
	@Enumerated(EnumType.STRING)
	private UserRole role;
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	
}
