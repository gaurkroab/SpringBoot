package com.gk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gk.entity.Employee_Date_Time;

public interface IEmployeeDateTimeRepository extends JpaRepository<Employee_Date_Time, Integer> {
	@Query(value="SELECT YEAR(CURRENT_TIMESTAMP)-YEAR(DOB) FROM EMPLOYEE_DATE_TIME WHERE DESG=:job", nativeQuery = true)
	public List<Integer> getEmployeeAgesByDesg(String job);
}
