package com.gk.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="employee_info")
@Data
public class Employee_Info {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer eno;
	private String ename;
	private String desg;
	private Double gross_salary;
	private Double net_salary;
	
}
