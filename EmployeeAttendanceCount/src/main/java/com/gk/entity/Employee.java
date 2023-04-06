package com.gk.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="AA_Employee")
@Setter
@Getter
public class Employee {

	@Id
	@SequenceGenerator(name="gen", sequenceName="EMP_ID_SEQ4", initialValue=1,allocationSize=1)
	@GeneratedValue(generator="gen", strategy=GenerationType.SEQUENCE)
	private Integer empId;
	private String empName;
	private String empAddrs;
	
	@OneToMany(targetEntity = Attendance.class, cascade = CascadeType.ALL)
	@JoinColumn(name="EMPLOYEE_ID", referencedColumnName = "EMPID")
	private Set<Attendance> attendance;
	
	public Employee() {
		System.out.println("EmployeeDetail 0- param constructor");
	}
}
