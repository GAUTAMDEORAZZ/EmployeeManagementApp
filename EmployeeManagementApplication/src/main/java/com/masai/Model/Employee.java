package com.masai.Model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employee_id;
	
	@NotNull
	private String name;
	
	@NotNull
	private Integer salary;
	
	@Min(value = 18, message="Your Age is not Less Than 18 year old")
	private Integer age;
	private Gender gender;
	
	@Embedded
	private Address address;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Department dept;
	

}
