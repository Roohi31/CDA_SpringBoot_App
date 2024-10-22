package org.jsp.cda.entity;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Faculty 
{
	
	@Id
	private int id;
	@MapsId
	@OneToOne
	private User user;
	private String photo;
	private LocalTime officeHours;
	
	@ManyToOne
	private Department department;
	
}
