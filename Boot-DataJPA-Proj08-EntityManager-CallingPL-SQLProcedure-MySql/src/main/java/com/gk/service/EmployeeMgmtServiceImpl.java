package com.gk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.entity.Employee_Info;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private EntityManager manager;
	@Override
	public List<Employee_Info> showEmployeeBySalaryRange(double start, double end) {
		// create StoredProcedureQuery object
		StoredProcedureQuery query = manager.createStoredProcedureQuery("p_employee_details_by_salary", Employee_Info.class);
		// register the parameters of the Stored Procedures 
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class,ParameterMode.IN);
		// set parameter values 
		query.setParameter(1, start);
		query.setParameter(2, end);
		// call PL/SQL procedure
		List<Employee_Info> list = query.getResultList();
		return list;
	}

}
