package com.gk.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="AA_Attendance")
@Setter
@Getter
public class Attendance {

	@Id
	@SequenceGenerator(name="gen", sequenceName="ATTEN_ID_SEQ4", initialValue=1,allocationSize=1)
	@GeneratedValue(generator="gen", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	private String startTime;
	
	private String endTime;
	
	private String ddate;

	@ManyToOne(targetEntity = Employee.class,cascade = CascadeType.ALL)
	@JoinColumn(name="EMPLOYEE_ID", referencedColumnName = "EMPID")
	private Employee employee;
	
	
	
	
	public Attendance() {
		System.out.println("AttendanceDetail - 0 param constructor");
	}
}
